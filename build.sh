#!/bin/bash

dir=$(basename "$PWD")
if [[ "$dir" != "server" && "$dir" !=  "aegis-server" ]]; then
    echo "프로젝트 ROOT 경로에서 실행해주세요"
    exit 1
fi

webpack && mvn clean install;

if [ ! -d "build" ]; then
    mkdir build
fi
cp target/aegis-*.jar build