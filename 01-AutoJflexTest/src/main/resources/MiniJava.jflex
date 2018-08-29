package br.ufpe.cin.if688.jflex;

%%

/* N�o altere as configura��es a seguir */

%line
%column
%unicode
//%debug
%public
%standalone
%class MiniJava
%eofclose

%{//parte código

%}

// Padroes Nomeados:
letter = [A-Za-z]
digit = [0-9]
whitespace = [ \n\t\r\f]
integer = {digit}+
alphanumeric = {letter}|{digit}
identifier = ({letter}|[_])({alphanumeric}|{_})*
/* Insira as regras l�xicas abaixo */

%%
{whitespace} {}
"&&" {System.out.println("Token AND"); }
"||" {System.out.println("TOKEN OR"); }
"+" {System.out.println("TOKEN +"); }
"-" {System.out.println("TOKEN -"); }
"*" {System.out.println("TOKEN *"); }
"(" {System.out.println("TOKEN ("); }
")" {System.out.println("TOKEN )"); }
{integer} {System.out.println("TOKEN INT ("+yytext()+")"); }
{identifier} {System.out.println("TOKEN ID ("+yytext()+")"); }


    
/* Insira as regras l�xicas no espa�o acima */     
     
. { throw new RuntimeException("Caractere ilegal! '" + yytext() + "' na linha: " + yyline + ", coluna: " + yycolumn); }
