package testtt;

public class Staff extends Pegawai implements Gaji{
	private String education;
	private int jamKerja;
	
	public Staff(String name, String gender, String noHp, String email, String status, String alamat,String loyaltyCardID, Integer Gaji,String education, int jamKerja) {
		super(name, gender, noHp, email, status, alamat, loyaltyCardID, Gaji);
		// TODO Auto-generated constructor stub
		this.education = education;
		this.jamKerja = jamKerja;
	}

	public int getJamKerja() {
		return jamKerja;
	}

	public void setJamKerja(int jamKerja) {
		this.jamKerja = jamKerja;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Override
	public int generatePoint() {

		int currentPoint = (int)(Math.random()*(this.getName().length())) + 1;
		return currentPoint;
	
	}

	@Override
	public int dapatGaji() {
		int gaji = (int) (100.000 * this.generatePoint());
		System.out.println("Selamat anda mendapatkan gaji" + gaji);
		
		return gaji;
	}


	
}
