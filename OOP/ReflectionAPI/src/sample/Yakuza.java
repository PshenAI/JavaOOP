package sample;

import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Yakuza {

	private String familyName;
	private Map<String, String> familyMembers;

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String oyabunName) {
		this.familyName = oyabunName;
	}

	public Map<String, String> getFamilyMembers() {
		return familyMembers;
	}

	public void setFamilyMembers(Map<String, String> familyMembers) {
		this.familyMembers = familyMembers;
	}

	@TestAnnotation
	public void expelFromFamily(String name) {
		JFrame jFrame = new JFrame();
		int result = JOptionPane.showConfirmDialog(jFrame,
				"Are you sure you want to expel " + name + " from " + familyName + " family?");
		if (result == 0) {
			familyMembers.remove(name);
			System.out.println(name + " was taken care of.\n" + familyMembers);
		}
	}

	@Override
	public String toString() {
		return "Yakuza [familyName=" + familyName + ", familyMembers=" + familyMembers + "]";
	}

}
