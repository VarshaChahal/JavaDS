package ScenarioBasedProblems;

import java.util.ArrayList;
import java.util.Iterator;

//https://leetcode.com/problems/design-browser-history/

class BrowserHistory {
    ArrayList<String> urlList;
    int currentInd=0;

    public BrowserHistory(String homepage) {
        this.urlList = new ArrayList<String>();
        this.urlList.add(homepage);
        this.currentInd=0;
    }
    
    public void visit(String url) {
        //before you add the url to the list or urls, remove the forward history
            //remove all the elements that come after the currentPage
           
            //can improve the complexity by going from last element until the current because moving elements after deleting an element when going front to end
            for(int i=this.urlList.size()-1;i>this.currentInd;i--){
                this.urlList.remove(i);
            }
        
        //add the url to the list
        this.urlList.add(url);
        this.currentInd++;
    }
    
    public String back(int steps) {
        //what if the number of steps you are trying to go back is more than the number of elements you have in the history
        if(steps>=this.currentInd){
            this.currentInd = 0;
        }
        else{
            this.currentInd = this.currentInd-steps;
        }
        return this.urlList.get(this.currentInd);
    }
    
    public String forward(int steps) {
        int size = this.urlList.size();
        if(steps >= size-1-this.currentInd){
            this.currentInd = size-1;
        }else{
            this.currentInd = this.currentInd+steps;
        }
        return this.urlList.get(this.currentInd);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */