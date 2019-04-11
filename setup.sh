#!/bin/bash

SDK_INIT=~/.sdkman/bin/sdkman-init.sh

for PKG in bash curl
do
    if ! `pacman -Q ${PKG} >/dev/null 2>&1`
    then
        pacman -S ${PKG}
    fi
done

if [ ! -f ${SDK_INIT} ]
then
    curl -s "https://get.sdkman.io" | bash
fi

. ${SDK_INIT}

sdk install gradle
sdk install groovy
gradle wrapper