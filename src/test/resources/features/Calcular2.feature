Feature: Calcular as quatro operacoes
  Utilizar o app da calculadora do Google para realizar
  as quatro operacoes aritmeticas basicas
	
	Scenario: Somar dois numeros 
		Given que acesso a calculadora
		When clico no botao "9"
	# When clico no botao sorteado
		And clico no botao "+"
		And clico no botao "4"
		And clico no botao "="
		Then exibe o resultado como "13"