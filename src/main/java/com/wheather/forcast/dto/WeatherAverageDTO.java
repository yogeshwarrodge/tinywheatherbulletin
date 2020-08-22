package  com.wheather.forcast.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import javax.swing.text.Position.Bias;

public class WeatherAverageDTO implements Serializable {

	private static final long serialVersionUID = 5763148931413501367L;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate date;

	private BigDecimal daily;
	private BigDecimal duringWorkingHrsAvgTemp;
	private BigDecimal outsideWorkingHrsAvgTemp;

	private BigDecimal nightly;

	private BigDecimal pressure;
	private BigDecimal humidity;

	@JsonIgnore
	private BigDecimal totalDaily;

	@JsonIgnore
	private Integer quantDaily;

	@JsonIgnore
	private BigDecimal totalNightly;

	@JsonIgnore
	private Integer quantNightly;

	@JsonIgnore
	private BigDecimal totalPressure;
	@JsonIgnore
	private BigDecimal totalhumidity;
	
	

	@JsonIgnore
	private Integer quantPressure;
	@JsonIgnore
	private Integer quanthumidity;

	public WeatherAverageDTO() {
		this.totalDaily = BigDecimal.ZERO;
		this.totalNightly = BigDecimal.ZERO;
		this.totalPressure = BigDecimal.ZERO;
		this.totalhumidity = BigDecimal.ZERO;
		this.quantDaily = 0;
		this.quantNightly = 0;
		this.quantPressure = 0;
		this.quanthumidity=0;
	}

	public WeatherAverageDTO(LocalDate date, BigDecimal daily, BigDecimal nightly, BigDecimal pressure,
                             BigDecimal totalDaily, Integer quantDaily, BigDecimal totalNightly, Integer quantNightly,
                             BigDecimal totalPressure ,BigDecimal totalhumidity ,Integer quantPressure,Integer quanthumidity) {
		this.date = date;
		this.daily = daily;
		this.nightly = nightly;
		this.pressure = pressure;
		this.totalDaily = totalDaily;
		this.quantDaily = quantDaily;
		this.totalNightly = totalNightly;
		this.quantNightly = quantNightly;
		this.totalPressure = totalPressure;
		this.quantPressure = quantPressure;
		this.totalhumidity=totalhumidity;
		this.quanthumidity=quanthumidity;
	}

	public void plusMap(WeatherMapTimeDTO map) {
		if (map.isDaily()) {
			this.totalDaily = this.totalDaily.add(map.getMain().getTemp());
			this.quantDaily++;
		} else {
			this.totalNightly = this.totalNightly.add(map.getMain().getTemp());
			this.quantNightly++;
		}
		this.totalPressure = this.totalPressure.add(map.getMain().getTemp());
		this.quantPressure++;
		this.totalhumidity=this.totalhumidity.add(map.getMain().getHumidity());
		this.quanthumidity++;
	}

	public void totalize() {
		this.daily = (this.quantDaily > 0)
				? this.totalDaily.divide(new BigDecimal(this.quantDaily.toString()), 2, RoundingMode.HALF_UP)
				: null;
		this.nightly = (this.quantNightly > 0)
				? this.totalNightly.divide(new BigDecimal(this.quantNightly.toString()), 2, RoundingMode.HALF_UP)
				: null;
		this.duringWorkingHrsAvgTemp = (this.quantDaily > 0)
				? this.totalDaily.divide(new BigDecimal(this.quantDaily.toString()), 2, RoundingMode.HALF_UP)
				: null;
		this.outsideWorkingHrsAvgTemp = (this.quantNightly > 0)
				? this.totalNightly.divide(new BigDecimal(this.quantNightly.toString()), 2, RoundingMode.HALF_UP)
				: null;
		this.pressure = (this.quantPressure > 0)
				? this.totalPressure.divide(new BigDecimal(this.quantPressure.toString()), 2, RoundingMode.HALF_UP)
				: null;
		this.humidity=(this.quanthumidity > 0)
				? this.totalhumidity.divide(new BigDecimal(this.quanthumidity.toString()), 2, RoundingMode.HALF_UP)
			    : null;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public BigDecimal getDaily() {
		return daily;
	}

	public void setDaily(BigDecimal daily) {
		this.daily = daily;
	}

	public BigDecimal getNightly() {
		return nightly;
	}

	public void setNightly(BigDecimal nightly) {
		this.nightly = nightly;
	}

	public BigDecimal getPressure() {
		return pressure;
	}

	public void setPressure(BigDecimal pressure) {
		this.pressure = pressure;
	}

	public BigDecimal getTotalDaily() {
		return totalDaily;
	}

	public void setTotalDaily(BigDecimal totalDaily) {
		this.totalDaily = totalDaily;
	}

	public Integer getQuantDaily() {
		return quantDaily;
	}

	public void setQuantDaily(Integer quantDaily) {
		this.quantDaily = quantDaily;
	}

	public BigDecimal getTotalNightly() {
		return totalNightly;
	}

	public void setTotalNightly(BigDecimal totalNightly) {
		this.totalNightly = totalNightly;
	}

	public Integer getQuantNightly() {
		return quantNightly;
	}

	public void setQuantNightly(Integer quantNightly) {
		this.quantNightly = quantNightly;
	}

	public BigDecimal getTotalPressure() {
		return totalPressure;
	}

	public void setTotalPressure(BigDecimal totalPressure) {
		this.totalPressure = totalPressure;
	}

	public Integer getQuantPressure() {
		return quantPressure;
	}

	public void setQuantPressure(Integer quantPressure) {
		this.quantPressure = quantPressure;
	}

	public BigDecimal getHumidity() {
		return humidity;
	}

	public void setHumidity(BigDecimal humidity) {
		this.humidity = humidity;
	}

	public BigDecimal getTotalhumidity() {
		return totalhumidity;
	}

	public void setTotalhumidity(BigDecimal totalhumidity) {
		this.totalhumidity = totalhumidity;
	}

	public Integer getQuanthumidity() {
		return quanthumidity;
	}

	public void setQuanthumidity(Integer quanthumidity) {
		this.quanthumidity = quanthumidity;
	}

	public BigDecimal getDuringWorkingHrsAvgTemp() {
		return duringWorkingHrsAvgTemp;
	}

	public void setDuringWorkingHrsAvgTemp(BigDecimal duringWorkingHrsAvgTemp) {
		this.duringWorkingHrsAvgTemp = duringWorkingHrsAvgTemp;
	}

	public BigDecimal getOutsideWorkingHrsAvgTemp() {
		return outsideWorkingHrsAvgTemp;
	}

	public void setOutsideWorkingHrsAvgTemp(BigDecimal outsideWorkingHrsAvgTemp) {
		this.outsideWorkingHrsAvgTemp = outsideWorkingHrsAvgTemp;
	}



	
}
