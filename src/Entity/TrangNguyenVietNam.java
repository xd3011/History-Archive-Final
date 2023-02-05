package Entity;

public class TrangNguyenVietNam implements ThucThe {
	private String ten;
	private String namSinh;
	private String que;
	private String namDo;
	private String doiVua;
	private String ghiChu;

	public TrangNguyenVietNam(String ten, String namSinh, String que, String namDo, String doiVua, String ghiChu) {
		super();
		this.ten = ten;
		this.namSinh = namSinh;
		this.que = que;
		this.namDo = namDo;
		this.doiVua = doiVua;
		this.ghiChu = ghiChu;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}

	public String getQue() {
		return que;
	}

	public void setQue(String que) {
		this.que = que;
	}

	public String getNamDo() {
		return namDo;
	}

	public void setNamDo(String namDo) {
		this.namDo = namDo;
	}

	public String getDoiVua() {
		return doiVua;
	}

	public void setDoiVua(String doiVua) {
		this.doiVua = doiVua;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
}
