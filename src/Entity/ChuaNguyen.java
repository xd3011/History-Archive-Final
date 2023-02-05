package Entity;

public class ChuaNguyen implements ThucThe {
	private String vuongHieu;
	private String mieuHieu;
	private String thuyHieu;
	private String tenHuy;
	private String thoiGianSong;
	private String ghiChu;

	public ChuaNguyen(String vuongHieu, String mieuHieu, String thuyHieu, String tenHuy, String thoiGianSong,
			String ghiChu) {
		super();
		this.vuongHieu = vuongHieu;
		this.mieuHieu = mieuHieu;
		this.thuyHieu = thuyHieu;
		this.tenHuy = tenHuy;
		this.thoiGianSong = thoiGianSong;
		this.ghiChu = ghiChu;
	}

	public String getVuongHieu() {
		return vuongHieu;
	}

	public void setVuongHieu(String vuongHieu) {
		this.vuongHieu = vuongHieu;
	}

	public String getMieuHieu() {
		return mieuHieu;
	}

	public void setMieuHieu(String mieuHieu) {
		this.mieuHieu = mieuHieu;
	}

	public String getThuyHieu() {
		return thuyHieu;
	}

	public void setThuyHieu(String thuyHieu) {
		this.thuyHieu = thuyHieu;
	}

	public String getTenHuy() {
		return tenHuy;
	}

	public void setTenHuy(String tenHuy) {
		this.tenHuy = tenHuy;
	}

	public String getThoiGianSong() {
		return thoiGianSong;
	}

	public void setThoiGianSong(String thoiGianSong) {
		this.thoiGianSong = thoiGianSong;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
}
