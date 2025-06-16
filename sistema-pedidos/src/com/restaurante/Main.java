package com.restaurante;

import com.restaurante.model.Pedido;
import com.restaurante.factory.*;
import com.restaurante.abstractfactory.*;
import com.restaurante.tema.*;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.*;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    private static List<Pedido> pedidos = criarPedidosExemplo();

    public static void main(String[] args) throws IOException {
        // Criar servidor HTTP na porta 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Configurar rotas
        server.createContext("/", new StaticFileHandler());
        server.createContext("/api/relatorio", new RelatorioHandler());
        server.createContext("/api/tema", new TemaHandler());
        server.createContext("/api/pedidos", new PedidosHandler());

        // Iniciar servidor
        server.setExecutor(null);
        server.start();

        System.out.println("Servidor iniciado em http://localhost:8080");
        System.out.println("Pressione Ctrl+C para parar o servidor");
    }

    // Handler para servir arquivos estáticos
    static class StaticFileHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String path = exchange.getRequestURI().getPath();

            if (path.equals("/")) {
                path = "/index.html";
            }

            String filePath = "sistema-pedidos/frontend" + path;
            File file = new File(filePath);

            if (file.exists() && !file.isDirectory()) {
                byte[] fileBytes = Files.readAllBytes(file.toPath());

                // Definir Content-Type
                String contentType = getContentType(path);
                exchange.getResponseHeaders().set("Content-Type", contentType);

                exchange.sendResponseHeaders(200, fileBytes.length);
                OutputStream os = exchange.getResponseBody();
                os.write(fileBytes);
                os.close();
            } else {
                String response = "404 - Arquivo não encontrado";
                exchange.sendResponseHeaders(404, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }

        private String getContentType(String path) {
            if (path.endsWith(".html"))
                return "text/html";
            if (path.endsWith(".css"))
                return "text/css";
            if (path.endsWith(".js"))
                return "application/javascript";
            return "text/plain";
        }
    }

    // Handler para relatórios
    static class RelatorioHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("GET".equals(exchange.getRequestMethod())) {
                String path = exchange.getRequestURI().getPath();
                String tipo = path.substring(path.lastIndexOf("/") + 1);

                RelatorioFactory factory = null;

                switch (tipo.toLowerCase()) {
                    case "pdf":
                        factory = new PdfRelatorioFactory();
                        break;
                    case "html":
                        factory = new HtmlRelatorioFactory();
                        break;
                    case "json":
                        factory = new JsonRelatorioFactory();
                        break;
                    default:
                        sendResponse(exchange, 400, "Tipo de relatório inválido");
                        return;
                }

                String relatorio = factory.gerarRelatorio(pedidos);
                sendResponse(exchange, 200, relatorio);
            } else {
                sendResponse(exchange, 405, "Método não permitido");
            }
        }
    }

    // Handler para temas
    static class TemaHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("GET".equals(exchange.getRequestMethod())) {
                String path = exchange.getRequestURI().getPath();
                String tema = path.substring(path.lastIndexOf("/") + 1);

                TemaFactory factory = null;

                switch (tema.toLowerCase()) {
                    case "light":
                        factory = new LightTemaFactory();
                        break;
                    case "dark":
                        factory = new DarkTemaFactory();
                        break;
                    case "highcontrast":
                        factory = new HighContrastTemaFactory();
                        break;
                    default:
                        sendResponse(exchange, 400, "Tema inválido");
                        return;
                }

                // Criar JSON com configurações do tema
                String json = criarJsonTema(factory);
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                sendResponse(exchange, 200, json);
            } else {
                sendResponse(exchange, 405, "Método não permitido");
            }
        }

        private String criarJsonTema(TemaFactory factory) {
            Botao botao = factory.criarBotao();
            Cor cor = factory.criarCor();
            Icone icone = factory.criarIcone();

            return "{\n" +
                    "  \"nome\": \"" + factory.getNomeTema() + "\",\n" +
                    "  \"botao\": {\n" +
                    "    \"estilo\": \"" + botao.getEstilo() + "\",\n" +
                    "    \"classe\": \"" + botao.getClasse() + "\",\n" +
                    "    \"texto\": \"" + botao.getTexto() + "\"\n" +
                    "  },\n" +
                    "  \"cor\": {\n" +
                    "    \"primaria\": \"" + cor.getCorPrimaria() + "\",\n" +
                    "    \"secundaria\": \"" + cor.getCorSecundaria() + "\",\n" +
                    "    \"fundo\": \"" + cor.getCorFundo() + "\",\n" +
                    "    \"texto\": \"" + cor.getCorTexto() + "\"\n" +
                    "  },\n" +
                    "  \"icone\": {\n" +
                    "    \"home\": \"" + icone.getIconeHome() + "\",\n" +
                    "    \"usuario\": \"" + icone.getIconeUsuario() + "\",\n" +
                    "    \"config\": \"" + icone.getIconeConfig() + "\",\n" +
                    "    \"relatorio\": \"" + icone.getIconeRelatorio() + "\"\n" +
                    "  }\n" +
                    "}";
        }
    }

    // Handler para pedidos
    static class PedidosHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("GET".equals(exchange.getRequestMethod())) {
                String json = criarJsonPedidos();
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                sendResponse(exchange, 200, json);
            } else {
                sendResponse(exchange, 405, "Método não permitido");
            }
        }

        private String criarJsonPedidos() {
            StringBuilder json = new StringBuilder();
            json.append("{\n  \"pedidos\": [\n");

            for (int i = 0; i < pedidos.size(); i++) {
                Pedido pedido = pedidos.get(i);
                json.append("    {\n");
                json.append("      \"id\": ").append(pedido.getId()).append(",\n");
                json.append("      \"cliente\": \"").append(pedido.getCliente()).append("\",\n");
                json.append("      \"item\": \"").append(pedido.getItem()).append("\",\n");
                json.append("      \"valor\": ").append(pedido.getValor()).append(",\n");
                json.append("      \"status\": \"").append(pedido.getStatus()).append("\"\n");
                json.append("    }");

                if (i < pedidos.size() - 1) {
                    json.append(",");
                }
                json.append("\n");
            }

            json.append("  ]\n}");
            return json.toString();
        }
    }

    private static void sendResponse(HttpExchange exchange, int statusCode, String response) throws IOException {
        exchange.sendResponseHeaders(statusCode, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private static List<Pedido> criarPedidosExemplo() {
        List<Pedido> pedidos = new ArrayList<>();

        pedidos.add(new Pedido(1, "João Silva", "Pizza Margherita", 25.90, "Entregue"));
        pedidos.add(new Pedido(2, "Maria Santos", "Hambúrguer Classic", 18.50, "Preparando"));
        pedidos.add(new Pedido(3, "Pedro Oliveira", "Salada Caesar", 15.00, "Pendente"));
        pedidos.add(new Pedido(4, "Ana Costa", "Lasanha Bolonhesa", 22.00, "Entregue"));
        pedidos.add(new Pedido(5, "Carlos Pereira", "Sushi Combo", 35.90, "Preparando"));

        return pedidos;
    }
}