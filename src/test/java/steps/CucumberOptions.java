package br.com.jussara.tests.stpes;

public @interface CucumberOptions {
    String features();

    String glue();

    String[] plugin();
}
