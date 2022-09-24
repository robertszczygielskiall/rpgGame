package com.eclipse.ec;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eclipse.ec.repository.Enemy;
import com.eclipse.ec.repository.EnemyType;
import com.eclipse.ec.repository.Material;
import com.eclipse.ec.repository.Origin;
import com.eclipse.ec.repository.Wapen;
import com.eclipse.ec.repository.WapenRepository;

@RestController
public class GameController {

	private String gameName;
	private int enemiesNumber;

	private WapenRepository wapenRepository;

	public GameController(WapenRepository wapenRepository) {
		this.wapenRepository = wapenRepository;
	}

	@RequestMapping(value = "/wapens", method = RequestMethod.GET)
	public ResponseEntity<List<Enemy>> getAllWapens() {
		return new ResponseEntity<List<Enemy>>(wapenRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/wapens/n", method = RequestMethod.GET)
	public ResponseEntity<List<Enemy>> getAllWapens2(@RequestParam("name") String enemyName) {
		return new ResponseEntity<List<Enemy>>(wapenRepository.findAll().stream()
				.filter(it -> it.getName().equals(enemyName)).collect(Collectors.toList()), HttpStatus.OK);
	}

	@RequestMapping(value = "/wapens/n", method = RequestMethod.POST)
	@Transactional
	public String addWapens2(@RequestParam("name") String enemyName) {
		var e = new Enemy();
		e.setHitPoints(10);
		e.setIntiative(10);
		e.setName(enemyName);
		
		var et = new EnemyType();
		et.setName("W");
		var o = new Origin();
		o.setIntiative(2);
		o.setName("P");
		et.setOrigin(o);
		e.setEnemyType(et);
		
		var m = new Material();
		m.setIntiative(1);
		e.setImmunity(m);
		
		var w = new Wapen();
		w.setHitPoints(3);
		w.setMaterial(m);
		w.setName("WW");
		e.setWapen(w);
		
		wapenRepository.save(e);
		return enemyName;
	}

	@RequestMapping(value = "/game", method = RequestMethod.GET)
	public String getGemeData() {
		return "my game data: " + gameName + " with " + enemiesNumber + " enemies";
	}

	@RequestMapping(value = "/game/{name}", method = RequestMethod.POST)
	@ResponseBody
	public String postGemeData(@PathVariable("name") String gameName) {
		this.gameName = gameName;
		return "my game name: " + gameName;
	}

	@RequestMapping(value = "/game/enemies", method = RequestMethod.PUT)
	@ResponseBody
	public String putGemeEnemies(@RequestParam("numb") int enemyNumb) {
		this.enemiesNumber = enemyNumb;
		return "set enemy numb: " + enemyNumb;
	}

}
