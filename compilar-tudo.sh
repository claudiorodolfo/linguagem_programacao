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

compilar_simples aulas/02-apresentacao-revisao/src
compilar_simples aulas/03-classes-objetos/src

echo ">> aulas/04-encapsulamento-relacionamentos (pacotes)"
mkdir -p aulas/04-encapsulamento-relacionamentos/out
javac --release 25 -d aulas/04-encapsulamento-relacionamentos/out \
  $(find aulas/04-encapsulamento-relacionamentos/src -name "*.java")

compilar_simples aulas/05-depuracao/src
compilar_simples aulas/05-depuracao/versao-corrigida
compilar_simples aulas/06-recursividade/src
compilar_simples aulas/07-prova-unidade-1/src
compilar_simples aulas/08-heranca/src
compilar_simples aulas/09-polimorfismo/src
compilar_simples aulas/10-interfaces-classes-abstratas/src
compilar_simples aulas/11-exercicios-integradores-poo/src
compilar_simples aulas/12-prova-unidade-2/src
compilar_simples aulas/13-boas-praticas/src
compilar_simples aulas/13-boas-praticas/versao-limpa
compilar_simples aulas/14-boxing-unboxing/src
compilar_simples aulas/15-exercicios-integradores/src
compilar_simples aulas/16-prova-unidade-3/src

echo "OK: tudo compilou."
