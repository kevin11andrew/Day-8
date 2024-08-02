# Grads_assignment_Day8_set1
Day 8 (2nd Aug 2024)

Set 1:
1)	Create a java application to test the following.
   
        a. Create threads by extending Thread class and Runnable interface
      
        b.Use join(),sleep() methods
      
        c.Synchronized method

2)  Create a java application to test the below features of collection framework.
    
            a. Store the objects and retrieve objects in ArrayList, Vector,LinkedList.
    
            b. Write a function which accepts array of objects returns the List object with the same data.

3) Make the below modifications to the Employee class given in Day7 Assignment.
   
           a. add Date of joining field of type Date

           b. Override hashCode and equals method

   Implement Comparable interface. While comparing two objects consider empno filed.
   
4) Create different implementation classes to Storage interface given in Day7 Assignment as given below.
   
             a.StorageListImpl: Use Array list for storing the employee objects 

             b.StorageSortedImpl: Use TreeSet for storing the employee objects

             c.StorageMapImpl: Use HashMap for storing the employee objects as values and empnos as keys

5) Modify getStorage() as mentioned below. Method should accept integer as a parameter
   
              a.Storage getStorage(int code) method
   
              b.If code=1 then return StorageImpl object
   
              c.If code=2 then return StorageListImpl
   
              d.If code=3 then return StorageSortedImpl
   
              e.For any other value return StorageMapImpl
