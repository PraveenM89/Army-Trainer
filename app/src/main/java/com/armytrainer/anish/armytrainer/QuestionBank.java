package com.armytrainer.anish.armytrainer;

/**
 * Created by Praveen on 2/25/2015.
 */
public abstract class QuestionBank {
    private static Question qBank[]= new Question[]{
            new Question(1,"Who gives re phonation to political parties in India ?","Parliament","Supreme court","President","Election commission","Election commission"),
            new Question(2,"The Chief Justice of a high court in India is appointed by the ","Governor of the State","Prime Minister of India","Supreme Court","President of India","President of India"),
            new Question(3,"The normal duration of Lok Sabha in India is ","4 years","5 years","5 years 6months","6years","5 years"),
            new Question(4,"In which year Osama Bin Laden was announced as most wanted terrorist ?","1999","2000","2003","2011","1999"),
            new Question(5,"Which is the top most largest armed forces of World War I ?","USA","RUSSIA","JAPAN","INDIA","USA"),
            new Question(6,"Which country suffered the greatest military losses in World War I?","RUSSIA","GERMANY","ITALY","USA","GERMANY"),
            new Question(7,"What is BSF expansion ?","Border Security Fighter","Border Security Force","Border Secretary Force","Border Sessional Force","Border Security Force"),
            new Question(8,"Which country has the highest military expenditure ?","USA","CHINA","INDIA","JAPAN","USA"),
            new Question(9,"In which year India Pakistan World War started ?","1947","1954","1978","1989","1947"),
            new Question(10,"Name the Indian high jumper who won a silver medal at London Paralympics Games ?","Girisha Hosanagara Nagarajegowda","Vijay Singh Chauhan","Suresh Babu","Hari Shankar Roy","Girisha Hosanagara Nagarajegowda"),
            new Question(11,"Which Indian female wrestler won Bronze in the World Junior Championship at Pattava on 6 September 2012?","Indu Choudhary","Geeta Phogat","Sonika Kaliraman","Alka tomar","Indu Choudhary"),
            new Question(12,"Name the Formula one driver who became the winner of Italian Grand Prix 2012","Fernando Alonso","Lewis Hamilton","Sebastian Vettel","Michael Schumacher","Lewis Hamilton"),
            new Question(13,"Name the New Zealand’s fast bowler who retired from both International and Domestic Cricket","Shane Bond","Daryl Tuffey","Ian Butler","Chris Martin","Daryl Tuffey"),
            new Question(14,"Women SAF football championship 2012 was won by which country?","Nepal","Bhutan","China","India","India"),
            new Question(15,"Name the owner of Delhi franchise of hockey India","Tata Group","Wave Group","Bharti Group","Aircel and Reliance","Wave Group"),
            new Question(16,"Name the Person of India who was appointed as Chief Economist of World Bank","Kaushik basu","Jaideep Sarkar","Narayan Murthy","Nandan Nilkeni","Kaushik basu"),
            new Question(17,"Name the person who on 13 September 2012 was appointed as the 39th Chief Justice of India","Justice Altamas Kabir","Justice A.K. Sikri","Rajeev Gupta","Justice Mohit Shantilal Shah","Justice Altamas Kabir"),
            new Question(18,"Which event will take place here at Horse Guards Parade?","Beach volleyball","Watersports","Boxing","Hockey","Beach volleyball"),
            new Question(19,"After the 2012 Games in London, where will the next Summer Olympic Games be held?","Brazil","Belize","Bolvia","Belgium","Brazil"),
            new Question(20,"Who is the founder of national army?","Mahatma Gandhi","Jawaharlal Nehru","Nethaji Subash Chandrabosh","Dalbir Singh","Jawaharlal Nehru")};

    public static Question[] getQuestionBank(){
        return qBank;
    }


}


