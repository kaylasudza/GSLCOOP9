package testtt;


public class Guru extends Pegawai implements Gaji{
	
	private String course;
	private int jamKerja;
	
	public Guru(String name, String gender, String noHp, String email, String status, String alamat, String loyaltyCardID, Integer Gaji,String course, int jamKerja) {
		super(name, gender, noHp, email, status, alamat, loyaltyCardID, Gaji);
		// TODO Auto-generated constructor stub
		this.course = course;
		this.jamKerja = jamKerja ;
	}

	public int getJamKerja() {
		return jamKerja;
	}

	public void setJamKerja(int jamKerja) {
		this.jamKerja = jamKerja;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public int generatePoint() {

		int currentPoint = (int)(Math.random()*(this.getName().length())) + 5;
		return currentPoint;
	
	}

	@Override
	public int dapatGaji() {
		int gaji = (int) (100.000 * this.generatePoint());
		System.out.println("Selamat anda mendapatkan gaji" + gaji);
		
		return gaji;
	}


}
