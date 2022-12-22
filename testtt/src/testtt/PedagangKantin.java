package testtt;

public class PedagangKantin extends Pegawai implements Gaji{
	private String jenisMakanan;
	private int jamKerja;
	
	public PedagangKantin(String name, String gender, String noHp, String email, String status, String alamat, String loyaltyCardID,Integer Gaji, String jenisMakanan,int jamKerja) {
		super(name, gender, noHp, email, status, alamat,loyaltyCardID, Gaji);
		// TODO Auto-generated constructor stub
		this.jenisMakanan = jenisMakanan ;
		this.jamKerja = jamKerja;
	}


	public int getJamKerja() {
		return jamKerja;
	}


	public void setJamKerja(int jamKerja) {
		this.jamKerja = jamKerja;
	}


	public String getJenisMakanan() {
		return jenisMakanan;
	}


	public void setJenisMakanan(String jenisMakanan) {
		this.jenisMakanan = jenisMakanan;
	}


	@Override
	public int generatePoint() {

		int currentPoint = (int)(Math.random()*(this.getName().length())) + 2;
		return currentPoint;
	
	}


	@Override
	public int dapatGaji() {
		int gaji = (int) (58.000 * this.generatePoint());
		System.out.println("Selamat anda mendapatkan gaji" + gaji);
		
		return gaji;
	}





}
