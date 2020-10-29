//need=> when you  given find the prime number in given range and the range are 10^12
//at that time you can not create array in this range so segmented seive is used

//step1-generate all prime numbers up to sqrt(r)
//step2-create an array of size r-l+1 and set all element to be 0(0: prime,1:composite)
//step3: for each prime p in range 2 to sqrt(r):
                // for every multiple m of p in range l ot r, mark index m-l as 1
//l=11 and r = 20
//array of 20-11+1 = 10
//0th index means 11..1st=12...20th is 9th index

//simple work as seive but just update the range 
