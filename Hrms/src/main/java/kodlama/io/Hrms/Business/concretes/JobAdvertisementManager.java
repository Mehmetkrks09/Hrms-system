package kodlama.io.Hrms.Business.concretes;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kodlama.io.Hrms.Business.abstracts.JobAdvertisementService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessDataResult;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.DataAccess.abstracts.CityDao;
import kodlama.io.Hrms.DataAccess.abstracts.EmployerDao;
import kodlama.io.Hrms.DataAccess.abstracts.JobAdvertisementDao;
import kodlama.io.Hrms.DataAccess.abstracts.JobDao;
import kodlama.io.Hrms.DataAccess.abstracts.WayOfWorkingDao;
import kodlama.io.Hrms.DataAccess.abstracts.WorkingTimeDao;
import kodlama.io.Hrms.entities.concretes.JobAdvertisement;
import kodlama.io.Hrms.entities.concretes.Dtos.JobAdvertisementDto;
import kodlama.io.Hrms.entities.concretes.Dtos.JobAdvertisementFilter;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	private EmployerDao employerDao;
	private JobDao jobDao;
	private WayOfWorkingDao wayOfWorkingDao;
	private WorkingTimeDao workingTimeDao;
	private CityDao cityDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, EmployerDao employerDao, JobDao jobDao,
			CityDao cityDao, WayOfWorkingDao wayOfWorkingDao, WorkingTimeDao workingTimeDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.employerDao = employerDao;
		this.jobDao = jobDao;
		this.wayOfWorkingDao = wayOfWorkingDao;
		this.workingTimeDao = workingTimeDao;
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll(), "Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployerIdAndIsActiveTrue(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getByEmployerIdAndIsActiveTrue(employerId));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrue());

	}

	@Override
	public DataResult<List<JobAdvertisement>> getByDeadlineLessThanEqual(String date) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByDeadlineLessThanEqual(date));

	}

	@Override
	public Result add(JobAdvertisementDto jobAdvertisementDto) {
		JobAdvertisement jobAdvertisement = new JobAdvertisement();
		jobAdvertisement.setId(1);
		jobAdvertisement.setDescription(jobAdvertisementDto.getDescription());
		jobAdvertisement.setMinSalary(jobAdvertisementDto.getSalaryMin());
		jobAdvertisement.setMaxSalary(jobAdvertisementDto.getSalaryMax());
		jobAdvertisement.setNumberOfOpenPositions(jobAdvertisementDto.getNumberOfOpenPositions());
		jobAdvertisement.setCreatedDate(LocalDate.now());

		jobAdvertisement.setDeadline(jobAdvertisementDto.getDeadline());
		jobAdvertisement.setActive(true);

		jobAdvertisement.setDeleted(false);
		jobAdvertisement.setEmployer(this.employerDao.getById(jobAdvertisementDto.getEmployerId()));
		jobAdvertisement.setJob(this.jobDao.getById(jobAdvertisementDto.getJobId()));
		jobAdvertisement.setCity(this.cityDao.getById(jobAdvertisementDto.getCityId()));
		jobAdvertisement.setWorkingTime(this.workingTimeDao.getById(jobAdvertisementDto.getWorkingTimeId()));
		jobAdvertisement.setWayOfWorking(this.wayOfWorkingDao.getById(jobAdvertisementDto.getWayOfWorkingId()));
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilani başarı şekilde eklendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByCityId(int cityId) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByCityId(cityId));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByWayOfWorkingId(int id) {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByWayOfWorkingId(id));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndWayOfWorkingIdAndWorkingTimeId(int wayOfWorkingId,
			int workingTimeId) {

		return new SuccessDataResult<List<JobAdvertisement>>(

				this.jobAdvertisementDao.getByIsActiveTrueAndWayOfWorkingIdAndWorkingTimeId(wayOfWorkingId,
						workingTimeId),
				"Advertisements Listed by Filter");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndWayOfWorkingIdAndWorkingTimeId(int wayOfWorkingId,
			int workingTimeId, Pageable pageable) {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao
				.getByIsActiveTrueAndWayOfWorkingIdAndWorkingTimeId(wayOfWorkingId, workingTimeId, pageable),
				"Aktif işler filtreye uygun listelendi ve pageable ");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActivatedWithPageable(Pageable pageable) {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrue(pageable),
				"Aktif iş ilanları listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndWayOfWorkingIdAndCityId(int wayOfWorkingId,
			int cityId) {
	
		return new SuccessDataResult<List<JobAdvertisement>>(

				this.jobAdvertisementDao.getByIsActiveTrueAndWayOfWorkingIdAndCityId(wayOfWorkingId,
						cityId),
				"Advertisements Listed by Filter");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndWayOfWorkingId(int wayOfWorkingId) {
		
return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByWayOfWorkingId(wayOfWorkingId),"Data Has Been Listed");
	}



}