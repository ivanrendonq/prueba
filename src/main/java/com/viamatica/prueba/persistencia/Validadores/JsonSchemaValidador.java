package com.viamatica.prueba.persistencia.Validadores;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonSchemaValidador {
     public boolean validateData(String jsonSchemaFilePath, String jsonDataFilePath) {
        try {
            String jsonSchema = readFile(jsonSchemaFilePath);
            JsonNode jsonSchemaNode = new ObjectMapper().readTree(jsonSchema);

            String jsonData = readFile(jsonDataFilePath);
            JsonNode jsonDataNode = new ObjectMapper().readTree(jsonData);

            JsonSchemaFactory schemaFactory = JsonSchemaFactory.byDefault();
            JsonSchema schema = schemaFactory.getJsonSchema(jsonSchemaNode);

            ProcessingReport report = schema.validate(jsonDataNode);

            if (report.isSuccess()) {
                System.out.println("Los datos son válidos");
                return true;
            } else {
                System.out.println("Los datos no son válidos. Errores:");
                System.out.println(report);
                return false;
            }
        } catch (IOException | ProcessingException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readString(path);
    }
}
