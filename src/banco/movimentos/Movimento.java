package banco.movimentos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Movimento {
private int tipoMovimento;
private LocalDate data;
private LocalTime hora;
private double valorMovimento;

public Movimento(int tipoMovimento, double valorMovimento) {
	super();
	this.data = LocalDate.now();
	this.hora = LocalTime.now();
	this.tipoMovimento = tipoMovimento;
	this.valorMovimento = valorMovimento;
}

public int getTipoMovimento() {
	return tipoMovimento;
}

public LocalDate getData() {
	return data;
}

public LocalTime getHora() {
	return hora;
}

public double getValorMovimento() {
	return valorMovimento;
}

@Override
public String toString() {
	return "Movimento: {tipoMovimento=" + tipoMovimento + ", data=" + data + ", hora=" + hora + ", valorMovimento="
			+ valorMovimento + "}";
}

}
