#!/usr/bin/env bash
# Compila todas as aulas (checagem do docente).
set -euo pipefail
ROOT="$(cd "$(dirname "$0")" && pwd)"
cd "$ROOT"

compilar_simples() {
  local dir="$1"
  echo ">> $dir"
  javac --release 25 "$dir"/*.java
}

compilar_pacote() {
  local src="$1"
  local out="$2"
  echo ">> $src (pacotes)"
  mkdir -p "$out"
  javac --release 25 -d "$out" $(find "$src" -name "*.java")
}

compilar_simples aulas/01-revisao-logica/src
compilar_simples aulas/02-poo-classes-objetos/src
compilar_simples aulas/03-atributos-construtores-metodos/src
compilar_pacote aulas/04-encapsulamento-pacotes/src aulas/04-encapsulamento-pacotes/out
compilar_pacote aulas/05-relacionamentos-cardinalidade/src aulas/05-relacionamentos-cardinalidade/out
compilar_simples aulas/06-diagrama-classes-uml/src
compilar_simples aulas/07-prova-unidade-1/src
compilar_simples aulas/08-recursividade/src
compilar_simples aulas/09-heranca/src
compilar_simples aulas/10-polimorfismo/src
compilar_simples aulas/11-interfaces-classes-abstratas/src
compilar_simples aulas/12-exercicios-integradores-poo/src
compilar_simples aulas/13-prova-unidade-2/src
compilar_simples aulas/14-depuracao/src
compilar_simples aulas/14-depuracao/versao-corrigida
compilar_simples aulas/15-boxing-unboxing/src
compilar_simples aulas/16-boas-praticas/src
compilar_simples aulas/16-boas-praticas/versao-limpa
compilar_simples aulas/17-exercicios-integradores/src
compilar_simples aulas/18-prova-unidade-3/src

echo "OK: tudo compilou."
