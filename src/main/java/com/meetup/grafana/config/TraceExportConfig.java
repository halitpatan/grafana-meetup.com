package com.meetup.grafana.config;

import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TraceExportConfig {

    @Bean
    public SpanExporter spanExporter(){
        SpanExporter spanExporter = OtlpGrpcSpanExporter.builder()
                .setEndpoint("http://otel-collector:4317")
                .build();
        return spanExporter;
    }
}
