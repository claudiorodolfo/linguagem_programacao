#!/usr/bin/env bash
# Compila e executa uma aula sem pacotes.
# Uso: ./compilar.sh aulas/02-poo-classes-objetos DemoClassesObjetos
set -euo pipefail

if [[ $# -lt 2 ]]; then
  echo "Uso: $0 <pasta-da-aula> <ClassePrincipal>"
  echo "Exemplo: $0 aulas/02-poo-classes-objetos DemoClassesObjetos"
  exit 1
fi

AULA="$1"
CLASSE="$2"
SRC="${AULA}/src"

if [[ ! -d "$SRC" ]]; then
  echo "Pasta não encontrada: $SRC"
  exit 1
fi

echo "Compilando ${SRC}/*.java (Java 25) ..."
javac --release 25 "${SRC}"/*.java
echo "Executando ${CLASSE} ..."
java -cp "$SRC" "$CLASSE"
