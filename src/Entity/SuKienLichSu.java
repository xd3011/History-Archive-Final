package Entity;

import java.util.ArrayList;

public class SuKienLichSu implements ThucThe {
	private String thoiDai;
	private String thoiGian;
	private String noiDungSuKien;
	private ArrayList<String> nhanVat = new ArrayList<String>();
	private ArrayList<String> trieuDai = new ArrayList<String>();

	public SuKienLichSu() {
	}

	public SuKienLichSu(String thoiDai, String thoiGian, String noiDungSuKien, ArrayList<String> nhanVat,
			ArrayList<String> trieuDai) {
		this.thoiDai = thoiDai;
		this.thoiGian = thoiGian;
		this.noiDungSuKien = noiDungSuKien;
		for (String c : nhanVat) {
			this.nhanVat.add(c);
		}
		for (String tr : trieuDai) {
			this.trieuDai.add(tr);
		}
	}

	public void setTenSuKien(String noiDung) {
		this.noiDungSuKien = noiDung;
	}

	public String getThoiDai() {
		return thoiDai;
	}

	public String getThoiGian() {
		return thoiGian;
	}

	public String getNoiDungSuKien() {
		return noiDungSuKien;
	}

	public String getNhanVat() {
		return nhanVat.toString();
	}

	public String getTrieuDai() {
		return trieuDai.toString();
	}
}
