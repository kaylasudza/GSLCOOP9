package testtt;

public class Siswa extends Pegawai{
	
	private int kelas; 
	
	public Siswa(String name, String gender, String noHp, String email, String status, String alamat ,String loyaltyCardID,Integer Gaji, int kelas ) {
		super(name, gender, noHp, email, status, alamat, loyaltyCardID, Gaji);
		// TODO Auto-generated constructor stub
		this.kelas = kelas;
		
	}
	public int getKelas() {
		return kelas;
	}
	public void setKelas(int kelas) {
		this.kelas = kelas;
	}
	@Override
	public int generatePoint() {

		int currentPoint = (int)(Math.random()*(this.getName().length())) ;
		return currentPoint;
	
	}

	

}
