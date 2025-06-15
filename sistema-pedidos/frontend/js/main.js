let temaAtual = null;

        // Carregar pedidos na inicialização
        document.addEventListener('DOMContentLoaded', function () {
            carregarPedidos();
        });

        // Função para carregar pedidos
        async function carregarPedidos() {
            try {
                const response = await fetch('/api/pedidos');
                const data = await response.json();

                const tbody = document.querySelector('#tabela-pedidos tbody');
                tbody.innerHTML = '';

                data.pedidos.forEach(pedido => {
                    const statusClass = getStatusClass(pedido.status);
                    const row = `
                        <tr>
                            <td>${pedido.id}</td>
                            <td>${pedido.cliente}</td>
                            <td>${pedido.item}</td>
                            <td>R$ ${pedido.valor.toFixed(2)}</td>
                            <td><span class="badge ${statusClass} status-badge">${pedido.status}</span></td>
                        </tr>
                    `;
                    tbody.innerHTML += row;
                });
            } catch (error) {
                console.error('Erro ao carregar pedidos:', error);
                alert('Erro ao carregar pedidos. Verifique se o servidor está rodando.');
            }
        }

        // Função para aplicar tema
        async function aplicarTema(tema) {
            try {
                const response = await fetch(`/api/tema/${tema}`);
                const temaData = await response.json();

                temaAtual = temaData;

                // Aplicar cores CSS
                const root = document.documentElement;
                root.style.setProperty('--cor-primaria', temaData.cor.primaria);
                root.style.setProperty('--cor-secundaria', temaData.cor.secundaria);
                root.style.setProperty('--cor-fundo', temaData.cor.fundo);
                root.style.setProperty('--cor-texto', temaData.cor.texto);

                // Exibir informações do tema
                const temaInfo = document.getElementById('tema-info');
                temaInfo.innerHTML = `
                    <div class="alert alert-info">
                        <h6><i class="bx bx-info-circle"></i> Tema Aplicado: ${temaData.nome}</h6>
                        <p class="mb-0">
                            <strong>Cores:</strong> 
                            Primária: ${temaData.cor.primaria}, 
                            Fundo: ${temaData.cor.fundo}, 
                            Texto: ${temaData.cor.texto}
                        </p>
                        <p class="mb-0">
                            <strong>Ícones:</strong> ${temaData.icone.home}, ${temaData.icone.usuario}, ${temaData.icone.relatorio}
                        </p>
                    </div>
                `;

            } catch (error) {
                console.error('Erro ao aplicar tema:', error);
                alert('Erro ao aplicar tema.');
            }
        }

        // Função para gerar relatório
        async function gerarRelatorio(tipo) {
            try {
                const response = await fetch(`/api/relatorio/${tipo}`);
                const relatorio = await response.text();

                document.getElementById('relatorio-output').textContent = relatorio;
            } catch (error) {
                console.error('Erro ao gerar relatório:', error);
                alert('Erro ao gerar relatório.');
            }
        }

        // Demonstração integrada
        async function demonstracaoIntegrada() {
            if (!temaAtual) {
                alert('Por favor, selecione um tema primeiro!');
                return;
            }

            try {
                // Gerar relatório HTML
                const response = await fetch('/api/relatorio/html');
                const relatorioHtml = await response.text();

                // Aplicar tema ao relatório
                const relatorioComTema = relatorioHtml.replace(
                    'body { font-family: Arial, sans-serif; margin: 20px; }',
                    `body { font-family: Arial, sans-serif; margin: 20px; background-color: ${temaAtual.cor.fundo}; color: ${temaAtual.cor.texto}; }`
                ).replace(
                    'th { background-color: #f2f2f2; }',
                    `th { background-color: ${temaAtual.cor.primaria}; color: ${temaAtual.cor.texto}; }`
                );

                // Exibir resultado
                const demoDiv = document.getElementById('demo-integrada');
                demoDiv.innerHTML = `
                    <div class="alert alert-success">
                        <h6><i class="bx bx-check-circle"></i> Demonstração Integrada Executada!</h6>
                        <p><strong>Factory Method:</strong> Relatório HTML gerado</p>
                        <p><strong>Abstract Factory:</strong> Tema "${temaAtual.nome}" aplicado</p>
                        <button class="btn btn-sm btn-outline-primary" onclick="mostrarRelatorioIntegrado()">
                            Ver Relatório Completo
                        </button>
                    </div>
                `;

                // Armazenar relatório para visualização
                window.relatorioIntegrado = relatorioComTema;

            } catch (error) {
                console.error('Erro na demonstração integrada:', error);
                alert('Erro na demonstração integrada.');
            }
        }

        // Mostrar relatório integrado em nova janela
        function mostrarRelatorioIntegrado() {
            if (window.relatorioIntegrado) {
                const novaJanela = window.open('', '_blank');
                novaJanela.document.write(window.relatorioIntegrado);
                novaJanela.document.close();
            }
        }

        // Função auxiliar para classes de status
        function getStatusClass(status) {
            switch (status.toLowerCase()) {
                case 'entregue': return 'bg-success';
                case 'preparando': return 'bg-warning';
                case 'pendente': return 'bg-danger';
                default: return 'bg-secondary';
            }
        }