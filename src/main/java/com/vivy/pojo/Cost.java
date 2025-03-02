package com.vivy.pojo;

public class Cost {
    int id;
    String costId;
    String name;
    String department;
    String destination;
    String departureDate;
    String returnDate;
    String reason;
    double startFare;
    double returnFare;
    double foodallowance;
    double localtrans;
    double accommodation;
    double totalamount;
    String schedule;
    String scheduleReason;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCostId() {
        return costId;
    }

    public void setCostId(String costId) {
        this.costId = costId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public double getStartFare() {
        return startFare;
    }

    public void setStartFare(double startFare) {
        this.startFare = startFare;
    }

    public double getReturnFare() {
        return returnFare;
    }

    public void setReturnFare(double returnFare) {
        this.returnFare = returnFare;
    }

    public double getFoodallowance() {
        return foodallowance;
    }

    public void setFoodallowance(double foodallowance) {
        this.foodallowance = foodallowance;
    }

    public double getLocaltrans() {
        return localtrans;
    }

    public void setLocaltrans(double localtrans) {
        this.localtrans = localtrans;
    }

    public double getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(double accommodation) {
        this.accommodation = accommodation;
    }

    public double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(double totalamount) {
        this.totalamount = totalamount;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getScheduleReason() {
        return scheduleReason;
    }

    public void setScheduleReason(String scheduleReason) {
        this.scheduleReason = scheduleReason;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "id=" + id +
                ", costId='" + costId + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", destination='" + destination + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", reason='" + reason + '\'' +
                ", startFare=" + startFare +
                ", returnFare=" + returnFare +
                ", foodallowance=" + foodallowance +
                ", localtrans=" + localtrans +
                ", accommodation=" + accommodation +
                ", totalamount=" + totalamount +
                ", schedule='" + schedule + '\'' +
                ", scheduleReason='" + scheduleReason + '\'' +
                '}';
    }
}
