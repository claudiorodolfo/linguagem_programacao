#!/usr/bin/env bash
# Compila todas as aulas (checagem do docente).
set -euo pipefail
ROOT="$(cd "$(dirname "$0")" && pwd)"
cd "$ROOT"

compilar_pacote() {
  local src="$1"
  local out="$2"
  echo ">> $src"
  mkdir -p "$out"
  javac --release 25 -d "$out" $(find "$src" -name "*.java")
}

compilar_pacote aulas/01-revisao-logica/src aulas/01-revisao-logica/bin
compilar_pacote aulas/02-poo-classes-objetos/src aulas/02-poo-classes-objetos/bin
compilar_pacote aulas/03-atributos-construtores-metodos/src aulas/03-atributos-construtores-metodos/bin
compilar_pacote aulas/04-encapsulamento-pacotes/src aulas/04-encapsulamento-pacotes/bin
compilar_pacote aulas/05-relacionamentos-cardinalidade/src aulas/05-relacionamentos-cardinalidade/bin
compilar_pacote aulas/06-diagrama-classes-uml/src aulas/06-diagrama-classes-uml/bin
compilar_pacote aulas/07-heranca/src aulas/07-heranca/bin
compilar_pacote aulas/08-polimorfismo/src aulas/08-polimorfismo/bin
compilar_pacote aulas/09-interfaces-classes-abstratas/src aulas/09-interfaces-classes-abstratas/bin
compilar_pacote aulas/10-classes-interna-externa/src aulas/10-classes-interna-externa/bin
compilar_pacote aulas/11-recursividade/src aulas/11-recursividade/bin
compilar_pacote aulas/12-exercicios-integradores-poo/src aulas/12-exercicios-integradores-poo/bin
compilar_pacote aulas/13-prova-unidade-2/src aulas/13-prova-unidade-2/bin
compilar_pacote aulas/14-depuracao/src aulas/14-depuracao/bin
compilar_pacote aulas/14-depuracao/versao-corrigida aulas/14-depuracao/bin-corrigida
compilar_pacote aulas/15-boxing-unboxing/src aulas/15-boxing-unboxing/bin
compilar_pacote aulas/16-boas-praticas/src aulas/16-boas-praticas/bin
compilar_pacote aulas/16-boas-praticas/versao-limpa aulas/16-boas-praticas/bin-limpo
compilar_pacote aulas/17-exercicios-integradores/src aulas/17-exercicios-integradores/bin
compilar_pacote aulas/18-prova-unidade-3/src aulas/18-prova-unidade-3/bin

echo "OK: tudo compilou."
