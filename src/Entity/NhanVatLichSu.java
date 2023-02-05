package Entity;

public class NhanVatLichSu implements ThucThe {
	private String Vua;
	private String MieuHieu;
	private String ThuyHieu;
	private String NienHieu;
	private String TenHuy;
	private String TheThu;
	private String TriVi;

	public NhanVatLichSu(String vua, String mieuHieu, String thuyHieu, String nienHieu, String tenHuy, String theThu,
			String triVi) {
		super();
		Vua = vua;
		MieuHieu = mieuHieu;
		ThuyHieu = thuyHieu;
		NienHieu = nienHieu;
		TenHuy = tenHuy;
		TheThu = theThu;
		TriVi = triVi;
	}

	public NhanVatLichSu() {
		// TODO Auto-generated constructor stub
	}

	public String getVua() {
		return Vua;
	}

	public void setVua(String vua) {
		Vua = vua;
	}

	public String getMieuHieu() {
		return MieuHieu;
	}

	public void setMieuHieu(String mieuHieu) {
		MieuHieu = mieuHieu;
	}

	public String getThuyHieu() {
		return ThuyHieu;
	}

	public void setThuyHieu(String thuyHieu) {
		ThuyHieu = thuyHieu;
	}

	public String getNienHieu() {
		return NienHieu;
	}

	public void setNienHieu(String nienHieu) {
		NienHieu = nienHieu;
	}

	public String getTenHuy() {
		return TenHuy;
	}

	public void setTenHuy(String tenHuy) {
		TenHuy = tenHuy;
	}

	public String getTheThu() {
		return TheThu;
	}

	public void setTheThu(String theThu) {
		TheThu = theThu;
	}

	public String getTriVi() {
		return TriVi;
	}

	public void setTriVi(String triVi) {
		TriVi = triVi;
	}
}
