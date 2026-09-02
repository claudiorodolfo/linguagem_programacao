#!/usr/bin/env bash
# Compila e executa uma aula (pacote br.edu.ifba.vdc.bsi.lp1).
# Uso: ./compilar.sh aulas/02-poo-classes-objetos DemoClassesObjetos
set -euo pipefail

PKG="br.edu.ifba.vdc.bsi.lp1"

if [[ $# -lt 2 ]]; then
  echo "Uso: $0 <pasta-da-aula> <ClassePrincipal>"
  echo "Exemplo: $0 aulas/02-poo-classes-objetos DemoClassesObjetos"
  exit 1
fi

AULA="$1"
CLASSE="$2"
SRC="${AULA}/src"
BIN="${AULA}/bin"

if [[ ! -d "$SRC" ]]; then
  echo "Pasta não encontrada: $SRC"
  exit 1
fi

mkdir -p "$BIN"
echo "Compilando ${SRC} (Java 25) ..."
javac --release 25 -d "$BIN" $(find "$SRC" -name "*.java")
echo "Executando ${PKG}.${CLASSE} ..."
java -cp "$BIN" "${PKG}.${CLASSE}"
