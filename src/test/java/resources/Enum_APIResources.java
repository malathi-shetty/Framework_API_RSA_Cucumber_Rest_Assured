package resources;

//enum is special class in java which has collection of constants and methods
public enum Enum_APIResources {
	
	AddPlaceAPI("maps/api/place/add/json"),
	getPlaceAPI("maps/api/place/get/json"),
	deletePlaceAPI("maps/api/place/delete/json");

	private String resource;

	Enum_APIResources(String resource) {
		this.resource = resource;
	}
	
	public String getResource()
	{
		return resource;
	}

}
