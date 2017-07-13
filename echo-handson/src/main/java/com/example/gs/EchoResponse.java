package com.example.gs;

public final class EchoResponse {

    private final String echo;

    public EchoResponse(final String echo) {
        this.echo = echo;
    }

    public String getEcho() {
        return echo;
    }
}
