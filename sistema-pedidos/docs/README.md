# atividade-PdP
Sistema de Gerenciamento de Pedidos De Restaurante - Protótipos de Geração de Relatórios com Factory Method e Alternância de Temas de Interface com Abstract Method

# Explicação do Funcionamento do Sistema de Gerenciamento de Pedidos

## Visão Geral
O sistema de gerenciamento de pedidos de uma rede de restaurante utiliza dois padrões de projeto principais: **Factory Method** e **Abstract Factory**. Esses padrões são aplicados para gerar relatórios em diferentes formatos e alternar temas da interface, respectivamente.

---

## Factory Method
O **Factory Method** é utilizado para criar diferentes tipos de relatórios (PDF, HTML e JSON). Ele permite que a lógica de criação seja delegada a subclasses específicas, garantindo flexibilidade e extensibilidade.

### Classes Relacionadas
- **Relatorio**: Interface que define os métodos `gerar` e `getTipo`.
- **HtmlRelatorio**, **PdfRelatorio**, **JsonRelatorio**: Implementações concretas da interface `Relatorio`, cada uma gerando o relatório em um formato específico.
- **RelatorioFactory**: Classe abstrata que define o método `criarRelatorio`.
- **HtmlRelatorioFactory**, **PdfRelatorioFactory**, **JsonRelatorioFactory**: Subclasses concretas de `RelatorioFactory`, responsáveis por criar instâncias específicas de relatórios.

### Funcionamento
1. O cliente solicita um relatório de um tipo específico (PDF, HTML ou JSON).
2. A fábrica correspondente (`PdfRelatorioFactory`, `HtmlRelatorioFactory`, etc.) cria o objeto de relatório apropriado.
3. O relatório é gerado utilizando os dados dos pedidos.

---

## Abstract Factory
O **Abstract Factory** é utilizado para alternar temas da interface, como Light, Dark e High Contrast. Ele permite que famílias de objetos relacionados (botões, cores e ícones) sejam criadas de forma consistente.

### Classes Relacionadas
- **TemaFactory**: Classe abstrata que define os métodos `criarBotao`, `criarCor`, `criarIcone` e `getNomeTema`.
- **LightTemaFactory**, **DarkTemaFactory**, **HighContrastTemaFactory**: Subclasses concretas de `TemaFactory`, responsáveis por criar os objetos específicos de cada tema.
- **Botao**, **Cor**, **Icone**: Interfaces que definem os métodos para os elementos do tema.
- **LightBotao**, **DarkBotao**, **HighContrastBotao**: Implementações concretas da interface `Botao`.
- **LightCor**, **DarkCor**, **HighContrastCor**: Implementações concretas da interface `Cor`.
- **LightIcone**, **DarkIcone**, **HighContrastIcone**: Implementações concretas da interface `Icone`.

### Funcionamento
1. O cliente seleciona um tema (Light, Dark ou High Contrast).
2. A fábrica correspondente (`LightTemaFactory`, `DarkTemaFactory`, etc.) cria os objetos relacionados ao tema (botão, cor e ícone).
3. Os elementos do tema são aplicados à interface.

---

## Integração dos Padrões
O sistema demonstra a integração dos dois padrões:
- O **Factory Method** gera relatórios em diferentes formatos.
- O **Abstract Factory** aplica temas aos relatórios gerados, garantindo consistência visual.

Essa abordagem modular facilita a manutenção e a extensão do sistema, permitindo adicionar novos formatos de relatório ou temas sem modificar o código existente.

---

## Benefícios
- **Flexibilidade**: Adição de novos formatos de relatório ou temas sem impacto no código existente.
- **Reutilização**: Componentes reutilizáveis e independentes.
- **Manutenção**: Código organizado e fácil de entender.

Este sistema é um exemplo prático de como os padrões de projeto podem ser aplicados para resolver problemas reais de forma eficiente e escalável.
