#!/usr/bin/env zsh

up() {
    docker-compose up -d
}

status() {
    docker-compose ps
}

start() {
    docker-compose start
}

stop() {
    docker-compose stop
}