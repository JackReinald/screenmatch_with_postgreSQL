package com.aluracursos.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    /* Esta clase es inútil dado que para acceder al API de chatGPT incluso gratuitamente necesitas
    una cuenta paga, añadiendo la info. de la tarjeta, por lo tanto será descartado su uso.
     */
    public static String obtenerTraduccion(String texto) {
        OpenAiService service = new OpenAiService("sk-proj-tf70nTjxcIjAf3wUJ9CjT3BlbkFJaSeb2HFfRqAppbSdk8KU"); //OpenAO API key

        CompletionRequest requisicion = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traduce a español el siguiente texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var respuesta = service.createCompletion(requisicion);
        return respuesta.getChoices().get(0).getText();
    }
}