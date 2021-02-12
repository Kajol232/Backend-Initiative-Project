package com.example.muhammad.backendinitiative.levelone.arraycrudapi.service.serviceImplementation;

import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.Movie;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.Rentals;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.Response;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.repository.RentalRepositories;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.service.serviceImplementationInterface.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

@Service
public class RentalServiceImpl implements RentalService {
    @Autowired
    RentalRepositories rentalRepositories;
    Response response = new Response();

    Scanner s = new Scanner(System.in);

    @Override
    public Object addRentals(Rentals rentals) {
        if(rentals == null){
            response.setStatus("05");
            response.setMessage("Invalid rental details");
        }else {
            Date d =generateReturnDate();
            rentals.setReturnDate(d);
            double p = rentals.getMovie().getPrice();
            System.out.println("Rental Price is" + p);
            System.out.println("Enter y/n to continue to payment board");
            String in = s.next();
            if(in.equalsIgnoreCase("y")){
                if(checkPayment()) {
                    rentals.setStatus(false);
                    rentalRepositories.save(rentals);
                    response.setStatus("00");
                    response.setMessage("Return Date is:" + d);
                }else{
                    response.setStatus("402");
                    response.setMessage("Payment Invalidated");
                }
            }else{
                response.setStatus("499");
                response.setMessage("Request cancelled");
            }


        }
        return response;
    }

    @Override
    public Object editRentals(int id, Rentals rentals) {
        Rentals r = rentalRepositories.findById(id).get();
        if (rentals != null){
            r.setMovie(rentals.getMovie());
            r.setUser(rentals.getUser());
            double bal = r.getMovie().getPrice() -  rentals.getMovie().getPrice();
            System.out.println(getBalanceStatus(bal));
            System.out.println("Enter y/n to continue to payment board");
            String in = s.next();
            if(in.equalsIgnoreCase("y")){
                if(checkPayment()) {
                    rentals.setStatus(false);
                    rentalRepositories.save(rentals);
                    rentalRepositories.save(r);
                    response.setStatus("00");
                    response.setMessage("Details updated successfully");
                }else{
                    response.setStatus("402");
                    response.setMessage("Payment Invalidated");
                }
            }else{
                response.setStatus("499");
                response.setMessage("Request cancelled");
            }


        }else{
            response.setStatus("403");
            response.setMessage("Rental does not exist");
        }
        return response;
    }

    private boolean checkPayment(){
        return true;
    }

    private Date generateReturnDate() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 7);
        return c.getTime();
    }

    private String getBalanceStatus(double bal){
        if(bal > 1){
            return "You will be refunded with" + bal;
        }else if (bal < 1){
            return "You are to pay up additional" + bal;
        }else{
            return "No payment required";

        }
    }

}
