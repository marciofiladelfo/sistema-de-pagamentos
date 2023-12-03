package com.desafiobackendjr.desafiobackendjrgiulianabezerra.config;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public record Transacao (
        Long id,
        Integer tipo,
        Date data,
        BigDecimal valor,
        Long cpf,
        String cartao,
        Time hora,
        String donoDaLoja,
        String nomeDaLoja){

    public Transacao whithValor(BigDecimal valor){
        return new Transacao(this.id(), this.tipo(), this.data(), valor, this.cpf(), this.cartao(), this.hora(),
                this.donoDaLoja().trim(), this.nomeDaLoja().trim());

    }

    public Transacao whithData(String data) throws ParseException {
        var dateFormat = new SimpleDateFormat("yyyyMMdd");
        var date = dateFormat.parse(data);
        return new Transacao(this.id(), this.tipo(), new Date(date.getTime()), this.valor(), this.cpf(), this.cartao(),
                this.hora(), this.donoDaLoja().trim(), this.nomeDaLoja().trim());
    }

    public Transacao whithHora(String hora) throws ParseException {
        var timeFormat = new SimpleDateFormat("HHmmss");
        var time = timeFormat.parse(hora);
        return new Transacao(this.id(), this.tipo(), this.data(), this.valor(), this.cpf(), this.cartao(),
                new Time(time.getTime()), this.donoDaLoja().trim(), this.nomeDaLoja().trim());
    }
}
