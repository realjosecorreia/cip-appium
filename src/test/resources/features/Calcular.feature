Feature: Calcular as quatro operacoes
  Utilizar o app da calculadora do Google para realizar
  as quatro operacoes aritmeticas basicas
		
	Scenario Outline: Subtrair entre dois numeros
		Given que acesso a calculadora
		When clico no botao <num1>
		And clico no botao <operador>
		And clico no botao <num2>
		And clico no botao "="
		Then exibe o resultado como <resultadoEsperado>
	Examples:
	| num1 | operador | num2 | resultadoEsperado |
	| "4"  | "+"      | "1"  | "5"               |
	| "8"  | "-"      | "2"  | "6"               |
	| "6"  | "*"      | "3"  | "18"              |
	| "8"  | "/"      | "4"  | "2"               |
		
	Scenario: Soma de dois numeros
		Given que acesso a calculadora
		When clico no botao "8"
		And clico no botao "5"
		And clico no botao "+"
		And clico no botao "1"
		And clico no botao "5"
		And clico no botao "="
		Then exibe o resultado como "100"
		
	Scenario: Subtrair entre dois numeros
		Given que acesso a calculadora
		When clico no botao "9"
		And clico no botao "-"
		And clico no botao "2"
		And clico no botao "="
		Then exibe o resultado como "7"