package beans;

public class ClFacturaVenta {
	private String periodo, moneda, fecha, tipoDoc, serieDoc, numDoc, cod_Cli, razonS_Cli, cod_Re, des_Re, glosa_venta,
			cod_estado, des_estado;
	private double tipoCambio, valorVenta, valorInafecto, igv, total;
	private int tasa_re;

	public String getPeriodo() {
		return periodo;
	}

	public String getDes_estado() {
		return des_estado;
	}

	public void setDes_estado(String des_estado) {
		this.des_estado = des_estado;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getSerieDoc() {
		return serieDoc;
	}

	public void setSerieDoc(String serieDoc) {
		this.serieDoc = serieDoc;
	}

	public String getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}

	public String getCod_Cli() {
		return cod_Cli;
	}

	public void setCod_Cli(String cod_Cli) {
		this.cod_Cli = cod_Cli;
	}

	public String getRazonS_Cli() {
		return razonS_Cli;
	}

	public void setRazonS_Cli(String razonS_Cli) {
		this.razonS_Cli = razonS_Cli;
	}

	public String getCod_Re() {
		return cod_Re;
	}

	public void setCod_Re(String cod_Re) {
		this.cod_Re = cod_Re;
	}

	public String getDes_Re() {
		return des_Re;
	}

	public void setDes_Re(String des_Re) {
		this.des_Re = des_Re;
	}

	public String getGlosa_venta() {
		return glosa_venta;
	}

	public void setGlosa_venta(String glosa_venta) {
		this.glosa_venta = glosa_venta;
	}

	public String getCod_estado() {
		return cod_estado;
	}

	public void setCod_estado(String cod_estado) {
		this.cod_estado = cod_estado;
	}

	public double getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public double getValorVenta() {
		return valorVenta;
	}

	public void setValorVenta(double valorVenta) {
		this.valorVenta = valorVenta;
	}

	public double getValorInafecto() {
		return valorInafecto;
	}

	public void setValorInafecto(double valorInafecto) {
		this.valorInafecto = valorInafecto;
	}

	public double getIgv() {
		return igv;
	}

	public void setIgv(double igv) {
		this.igv = igv;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getTasa_re() {
		return tasa_re;
	}

	public void setTasa_re(int tasa_re) {
		this.tasa_re = tasa_re;
	}

}
