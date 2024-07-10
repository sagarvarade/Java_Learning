package designpatterns.Creational.Prototype;

import java.util.List;
import java.util.Objects;

public class FileImporter implements Cloneable {

	private String name;
	private String location;
	private String loading;

	private List<String> fileList=List.of("AA","BB");
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLoading() {
		return loading;
	}

	public void setLoading(String loading) throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("1");
		this.loading = loading;
	}

	public List<String> getFileList() {
		return fileList;
	}

	public void setFileList(List<String> fileList) {
		this.fileList = fileList;
	}

	@Override
	public String toString() {
		return "FileImporter [name=" + name + ", location=" + location + ", loading=" + loading + ", fileList="
				+ fileList + ", getName()=" + getName() + ", getLocation()=" + getLocation() + ", getLoading()="
				+ getLoading() + ", getFileList()=" + getFileList() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fileList, loading, location, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileImporter other = (FileImporter) obj;
		return Objects.equals(fileList, other.fileList) && Objects.equals(loading, other.loading)
				&& Objects.equals(location, other.location) && Objects.equals(name, other.name);
	}

	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
	
}
