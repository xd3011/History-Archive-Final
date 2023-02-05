package Entity;

import java.util.ArrayList;

public class TrieuDai implements ThucThe {

	private String tenTrieuDai;
	private String thoiGian;
	private String viThe;
	private String tonGiaoChinh;
	private String chinhPhu;
	private String thuDo;
	private String tenNuoc;
	private ArrayList<NhanVatLichSu> listNhanVat;
	private ArrayList<SuKienLichSu> listSuKien;
	private ArrayList<DiTichLichSu> listDiTich;

	public void addDiTich(DiTichLichSu d) {
		if (listDiTich == null)
			listDiTich = new ArrayList<>();
		listDiTich.add(d);
	}

	public void addSuKien(SuKienLichSu s) {
		if (listSuKien == null)
			listSuKien = new ArrayList<>();
		listSuKien.add(s);
	}

	public void addNhanVat(NhanVatLichSu n) {
		if (listNhanVat == null)
			listNhanVat = new ArrayList<>();
		listNhanVat.add(n);
	}

	public String getTenNuoc() {
		return tenNuoc;
	}

	public void setTenNuoc(String tenNuoc) {
		this.tenNuoc = tenNuoc;
	}

	public void setTen(String ten) {
		this.tenTrieuDai = ten;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}

	public void setViThe(String viThe) {
		this.viThe = viThe;
	}

	public void setChinhPhu(String chinhPhu) {
		this.chinhPhu = chinhPhu;
	}

	public void setTonGiaoChinh(String tonGiaoChinh) {
		this.tonGiaoChinh = tonGiaoChinh;
	}

	public void setThuDo(String thuDo) {
		this.thuDo = thuDo;
	}

	public String getTenTrieuDai() {
		return tenTrieuDai;
	}

	public String getInFor() {
		String inFor = "";
		inFor += "Tên triều đại: " + this.tenTrieuDai;
		inFor += "\nThời gian: " + this.thoiGian;
		inFor += "\nVị Thế: " + this.viThe;
		inFor += "\nTôn giáo chính: " + this.tonGiaoChinh;
		inFor += "\nChính Phủ: " + this.chinhPhu;
		inFor += "\nThủ đô: " + this.thuDo;
		inFor += "\nTên nước: " + this.tenNuoc;
		return inFor;
	}
}
