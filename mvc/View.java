/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author Rui
 */
public class View implements Observer {

    Observable ob;

    public View(Observable ob) {
        this.ob = ob;
        ob.registerObserver(this);
    }

    /**
     * Funcionalidade: Mostrar o valor mais recente do sensor de temperatura
     *
     * @param temperatura
     */
    public void mostra_temperatura(HashMap<LocalDate, Vector<Integer>> temperatura) {
        int i = -100;
        LocalDate localDate = LocalDate.now();

        if (temperatura.containsKey(localDate)) {
            Vector<Integer> valores = temperatura.get(localDate);
            int size = valores.size();
            i = valores.elementAt(size - 1);
        }
        System.out.println("Temperatura Actual: " + i);
    }

    /**
     * Funcionalidade: Mostrar o valor mais recente do sensor de humidade
     *
     * @param humidade
     */
    public void mostra_humidade(HashMap<LocalDate, Vector<Integer>> humidade) {
        int value = -100;
        LocalDate localDate = LocalDate.now();

        if (humidade.containsKey(localDate)) {
            Vector<Integer> valores = humidade.get(localDate);
            int size = valores.size();
            value = valores.elementAt(size - 1);
        }
        System.out.println("Humidade Actual: " + value);
    }

    /**
     * Funcionalidade: Mostrar o valor mais recente do sensor de pressão
     * atmosférica
     *
     * @param pressao_atm
     */
    public void mostra_pressao_atm(HashMap<LocalDate, Vector<Integer>> pressao_atm) {
        int value = -100;
        LocalDate localDate = LocalDate.now();
        if (pressao_atm.containsKey(localDate)) {
            Vector<Integer> valores = pressao_atm.get(localDate);
            int size = valores.size();
            value = valores.elementAt(size - 1);
        }
        System.out.println("pressão atmosférica actual: " + value);
    }

    /**
     * Funcionalidade: Mostrar o valor mais recente do sensor de audio
     *
     * @param audio
     */
    public void mostra_audio(HashMap<LocalDate, Vector<Integer>> audio) {
        int value = -100;
        LocalDate localDate = LocalDate.now();

        if (audio.containsKey(localDate)) {
            Vector<Integer> valores = audio.get(localDate);
            int size = valores.size();
            value = valores.elementAt(size - 1);
        }
        System.out.println("Audio actual: " + value);
    }

    /**
     * Funcionalidade: Mostrar o valor mais recente do sensor de luminosidade
     *
     * @param luminosidade
     */
    public void mostra_luminosidade(HashMap<LocalDate, Vector<Integer>> luminosidade) {
        int value = -100;
        LocalDate localDate = LocalDate.now();

        if (luminosidade.containsKey(localDate)) {
            Vector<Integer> valores = luminosidade.get(localDate);
            int size = valores.size();
            value = valores.elementAt(size - 1);
        }
        System.out.println("Luminosidade actual: " + value);
    }

    /**
     * Funcionalidade: mostra a média da temperatura ou humidade para um
     * determinado dia
     *
     * @param data dia a considerar para a média
     * @param sensor sensor a calcular: 0 temperatura
     * @param temperatura
     * @param humidade
     */
    public void mostra_media(LocalDate data, int sensor, HashMap<LocalDate, Vector<Integer>> temperatura, HashMap<LocalDate, Vector<Integer>> humidade) {
        int sum = 0;
        int tamanho = 0;
        switch (sensor) {
            case 0: //temperatura
                if (temperatura.containsKey(data)) {

                    for (Integer val : temperatura.get(data)) {
                        sum += val;
                        tamanho++;
                    }

                    System.out.println("Média temperatura: " + sum / tamanho);
                }
                break;
            case 1: //humidade
                if (humidade.containsKey(data)) {

                    for (Integer val : humidade.get(data)) {
                        sum += val;
                        tamanho++;
                    }

                    System.out.println("Média humidade: " + sum / tamanho);
                }
                break;
        }
    }

    /**
     * Funcionalidade: Mostar os valores máximos e minimos do sensor de
     * temperatura
     *
     * @param data dia a considerar para recolher o valor máximo nosidade
     * @param temperatura
     */
    public void mostra_max_minimo_temperatura(LocalDate data, HashMap<LocalDate, Vector<Integer>> temperatura) {

        if (temperatura.containsKey(data)) {
            Vector<Integer> v = temperatura.get(data);
            int max = Collections.max(v);
            int min = Collections.min(v);
            System.out.println("Max temperatura: " + max + " Min temperatura: " + min);
        }
    }

    /**
     * Funcionalidade: Mostar os valores máximos e minimos do sensor de humidade
     *
     * @param data dia a considerar para recolher o valor máximo nosidade
     * @param humidade
     */
    public void mostra_max_minimo_humidade(LocalDate data, HashMap<LocalDate, Vector<Integer>> humidade) {

        if (humidade.containsKey(data)) {
            Vector<Integer> v = humidade.get(data);
            int max = Collections.max(v);
            int min = Collections.min(v);
            System.out.println("Max humidade: " + max + " Min humidade: " + min);
        }
    }

    /**
     * Funcionalidade: Mostar os valores máximos e minimos do sensor de pressão
     * atmosférica
     *
     * @param data dia a considerar para recolher o valor máximo nosidade
     * @param pressao_atm
     */
    public void mostra_max_minimo_pressao_atm(LocalDate data, HashMap<LocalDate, Vector<Integer>> pressao_atm) {

        if (pressao_atm.containsKey(data)) {
            Vector<Integer> v = pressao_atm.get(data);
            int max = Collections.max(v);
            int min = Collections.min(v);
            System.out.println("Max pressão atmosférica: " + max + " Min pressão atmosférica: " + min);
        }
    }

    /**
     * Funcionalidade: Mostar os valores máximos e minimos do sensor de audio
     *
     * @param data dia a considerar para recolher o valor máximo nosidade
     * @param audio
     */
    public void mostra_max_minimo_audio(LocalDate data, HashMap<LocalDate, Vector<Integer>> audio) {

        if (audio.containsKey(data)) {
            Vector<Integer> v = audio.get(data);
            int max = Collections.max(v);
            int min = Collections.min(v);
            System.out.println("Max Audio: " + max + " Min Audio: " + min);
        }
    }

    /**
     * Funcionalidade: Mostar os valores máximos e minimos do sensor de
     * luminosidade
     *
     * @param data dia a considerar para recolher o valor máximo nosidade
     * @param luminosidade
     */
    public void mostra_max_minimo_luminosidade(LocalDate data, HashMap<LocalDate, Vector<Integer>> luminosidade) {

        if (luminosidade.containsKey(data)) {
            Vector<Integer> v = luminosidade.get(data);
            int max = Collections.max(v);
            int min = Collections.min(v);
            System.out.println("Max Luminosidade: " + max + " Min Luminosidade: " + min);
        }
    }

    /**
     * Mostrar dos ultimos X dias os valores máximos e minimos de um sensor
     *
     * @param sensor sensor a mostrar
     * @param dias numero de dias a considerar desde a leitura mais actual.
     * @param temperatura
     */
    public void mostra_ultimos_dias(int sensor, int dias, HashMap<LocalDate, Vector<Integer>> temperatura) {

        int dias_counter = dias - 1;
        HashMap<LocalDate, Vector<Integer>> last_values = new HashMap<>();
        Vector max_min_values = new Vector();

        LocalDate today = LocalDate.now();
        while (dias_counter >= 0) {

            if (temperatura.containsKey(today.minusDays(dias_counter))) {
                Vector<Integer> temp_values = temperatura.get(today.minusDays(dias_counter));
                max_min_values.add(Collections.max(temp_values));
                max_min_values.add(Collections.min(temp_values));
                last_values.put(today.minusDays(dias_counter), max_min_values);

            }
            dias_counter -= 1;

        }
        System.out.println("Valores máximos e mínimos: " + last_values.toString());
    }

    @Override
    public void update(HashMap<LocalDate, Vector<Integer>> temperatura, HashMap<LocalDate, Vector<Integer>> humidade, HashMap<LocalDate, Vector<Integer>> pressao_atm, HashMap<LocalDate, Vector<Integer>> audio, HashMap<LocalDate, Vector<Integer>> luminosidade) {

        mostra_temperatura(temperatura);
        mostra_max_minimo_temperatura(LocalDate.now(), temperatura);
        mostra_max_minimo_humidade(LocalDate.now(), humidade);
        mostra_max_minimo_pressao_atm(LocalDate.now(), pressao_atm);
        mostra_max_minimo_audio(LocalDate.now(), audio);
        mostra_max_minimo_luminosidade(LocalDate.now(), luminosidade);
        mostra_pressao_atm(pressao_atm);
        mostra_humidade(humidade);
        mostra_media(LocalDate.now(), 0, temperatura, humidade);
        mostra_ultimos_dias(0, 2, temperatura);
    }

}
