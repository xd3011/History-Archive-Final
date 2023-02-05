package Entity;

public class LeHoiVanHoa implements ThucThe {
	private String thoiGianToChuc;
	private String diaDiem;
	private String tenLeHoi;
	private String lanDauToChuc;
	private String nhanVatLienQuan;
	private String ghiChu;

	public LeHoiVanHoa() {
	}

	public String getThoiGianToChuc() {
		return thoiGianToChuc;
	}

	public void setThoiGianToChuc(String thoiGianToChuc) {
		this.thoiGianToChuc = thoiGianToChuc;
	}

	public String getDiaDiem() {
		return diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public String getTenLeHoi() {
		return tenLeHoi;
	}

	public void setTenLeHoi(String tenLeHoi) {
		this.tenLeHoi = tenLeHoi;
	}

	public String getLanDauToChuc() {
		return lanDauToChuc;
	}

	public void setLanDauToChuc(String lanDauToChuc) {
		this.lanDauToChuc = lanDauToChuc;
	}

	public String getNhanVatLienQuan() {
		return nhanVatLienQuan;
	}

	public void setNhanVatLienQuan(String nhanVatLienQuan) {
		this.nhanVatLienQuan = nhanVatLienQuan;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public LeHoiVanHoa(String thoiGianToChuc, String diaDiem, String tenLeHoi, String lanDauToChuc,
			String nhanVatLienQuan, String ghiChu) {
		this.thoiGianToChuc = thoiGianToChuc;
		this.diaDiem = diaDiem;
		this.tenLeHoi = tenLeHoi;
		this.lanDauToChuc = lanDauToChuc;
		this.nhanVatLienQuan = nhanVatLienQuan;
		this.ghiChu = ghiChu;
	}
}
