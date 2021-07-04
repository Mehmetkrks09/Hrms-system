package kodlama.io.Hrms.api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Hrms.Business.abstracts.FavoriteAdvertisementService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessDataResult;
import kodlama.io.Hrms.entities.concretes.FavoriteAdvertisement;
import kodlama.io.Hrms.entities.concretes.Dtos.FavoriteAdvertisementDto;



@CrossOrigin
@RestController

@RequestMapping("/api/favoriteAdvertisement")
public class FavoriteAdvertisementController {
	private FavoriteAdvertisementService favoriteAdvertisementService;

	@Autowired
	public FavoriteAdvertisementController(FavoriteAdvertisementService favoriteAdvertisementService) {
		super();
		this.favoriteAdvertisementService = favoriteAdvertisementService;
	}
	

	   @GetMapping("/getall")
	   public DataResult<List<FavoriteAdvertisement>> getAll(){
		return favoriteAdvertisementService.getAll();
	   }

	    @GetMapping("/getByJobSeekerId")
	    public DataResult<List<FavoriteAdvertisement>> getByJobSeekerId(int id){
	    	return favoriteAdvertisementService.getAllByJobSeekerId(id);
	    }

	    @PostMapping("/add")
	   Result add(@RequestBody FavoriteAdvertisementDto favoriteAdvertisementDto) {
	    
	    	
	    	return favoriteAdvertisementService.add(favoriteAdvertisementDto);
	    }
	 

	    @PostMapping("/delete")
	    Result delete( int id) {
	    return favoriteAdvertisementService.delete(id);
	   	
	    }
}
	    
	    
	    