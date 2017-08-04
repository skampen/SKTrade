package runner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pojo.Ticker;

@SuppressWarnings("unchecked")
public class ManageTicker {
    private static SessionFactory factory;
//    public static void main(String[] args) {
//        try{
//            factory = new Configuration().configure().buildSessionFactory();
//        }catch (Throwable ex) {
//            System.err.println("Failed to create sessionFactory object." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//        ManageTicker MT = new ManageTicker();
//        LocalDateTime now = LocalDateTime.now();
//      /* Add few ticker records in database */
//        Integer empID1 = MT.addTicker(now,"USDT_BTC", "2738.76231502", "2738.76231501", "2737.31000003", "0.01888425","12895541.80779788","4739.76312700");
//        Integer empID2 = MT.addTicker(now,"USDT_BTC", "2738.51999999", "2738.51999999", "2735.33000001", "0.01690259","12690304.12270306","4663.28437851");
//        Integer empID3 = MT.addTicker(now,"USDT_BTC", "2738.51999999", "2738.51999999", "2735.43000002", "0.01539488","12615288.84520339","4635.35600351");
//
//      /* List down all the tickers */
//        MT.listTickers();
//
//      /* Update ticker's records */
////        MT.updateTicker(empID1, 5000);
//
//      /* Delete an ticker from the database */
////        MT.deleteTicker(empID2);
//
//      /* List down new list of the tickers */
//        MT.listTickers();
//    }

    /* Method to CREATE an ticker in the database */
    public Integer addTicker(LocalDateTime createdOn, String currencyPair, String last, String lowestAsk, String highestBid, String percentChange, String baseVolume, String quoteVolume){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer tickerID = null;
        try{
            tx = session.beginTransaction();
            Ticker ticker = new Ticker(createdOn, currencyPair, last, lowestAsk, highestBid, percentChange, baseVolume, quoteVolume);

            tickerID = (Integer) session.save(ticker);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return tickerID;
    }
    /* Method to  READ all the tickers */
    private void listTickers( ){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List tickers = session.createQuery("FROM Ticker").list();
            for(Ticker ticker : (List<Ticker>) tickers){
                System.out.print("Currency pair: " + ticker.getCurrencyPair());
                System.out.print("Last: " + ticker.getLast());
                System.out.println("Lowest ask: " + ticker.getLowestAsk());
                System.out.println("Highest bid: " + ticker.getHighestBid());
                System.out.println("Percent change: " + ticker.getPercentChange());
                System.out.println("Base volume: " + ticker.getBaseVolume());
                System.out.println("Quote volume: " + ticker.getQuoteVolume());
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    /* Method to UPDATE salary for an ticker */
//    public void updateTicker(Integer TickerID, int salary ){
//        Session session = factory.openSession();
//        Transaction tx = null;
//        try{
//            tx = session.beginTransaction();
//            Ticker ticker =
//                    (Ticker)session.get(Ticker.class, TickerID);
//            ticker.setSalary( salary );
//            session.update(ticker);
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//    }
//    /* Method to DELETE an ticker from the records */
//    public void deleteTicker(Integer TickerID){
//        Session session = factory.openSession();
//        Transaction tx = null;
//        try{
//            tx = session.beginTransaction();
//            Ticker ticker =
//                    (Ticker)session.get(Ticker.class, TickerID);
//            session.delete(ticker);
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//    }
}
