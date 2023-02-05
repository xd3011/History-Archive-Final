package Entity;

public class DiTichLichSu implements ThucThe {
	private String tenDiTich;
	private String viTri;
	private String loaiDiTich;
	private String namCN;
	private String ghiChu;

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public DiTichLichSu() {
	}

	public String getLoaiDiTich() {
		return this.loaiDiTich;
	}

	public void setLoaiDiTich(String loaiDiTich) {
		this.loaiDiTich = loaiDiTich;
	}

	public String getNamCN() {
		return this.namCN;
	}

	public void setNamCN(String namCN) {
		this.namCN = namCN;
	}

	public String getTenDiTich() {
		return this.tenDiTich;
	}

	public void setTenDiTich(String tenDiTich) {
		this.tenDiTich = tenDiTich;
	}

	public String getViTri() {
		return this.viTri;
	}

	public void setViTri(String viTri) {
		this.viTri = viTri;
	}
}
