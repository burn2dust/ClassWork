import numpy
import sys
from mpi4py import MPI
from mpi4py import ANY_SOURCE


comm = MPI.COMM_WORLD
rank = comm.Get_rank()
size = comm.Get_size()

##a = float(sys.argv[1])#number to calculate the position of pi
##b = float(sys.argv[2])#number to calculate the accuracy of pi
##n = int(sys.argv[3])  #number to parallelize by.

def pi ( userInput ):
        piIsEqualTo = 0.000000
        (float) piIsEqualTo = ((9801)/(sqrt(8)))*(1/(summation(userInput)))
        return piIsEqualTo

def summation( someLargeNumber ):
        	x = 0
        	results = 0.000000
    	for x in someLargeNumber:
       		(float) results += ((factorial(4*x)*(1103+26390*x))/((factorial(x)^4)*396^(4*x)))
    	return results

##def f(x):
##        return x*x
##
##def integrateRange(a,b,n):
##        integral = -(f(a) + f(b))/2.0
##        #n+1 trapazoidial points, n trapazoids
##        for x in numpy.linspace(a,b,n+1):
##            integral =+ f(x)
##        integral = integral*(b-a)/n
##        return integral
##
##h = (b-a)/n
##
##local_n = n/size
##
##local_a = a + rank*local_n*h
##local_b = local_a + local_h*h
##





integral = numpy.zeros(1)
recv_buffer = numpy.zeros(1)

input( "What would you like to calculate pi to? :", userInput)

##integral[0] = integrateRange
##data = [(pi(userInput) for x in range (1,size)]
##
##for i in range (0,size-1)
##	if rank == 1
##		comm.Send( data, dest = 0)
##	if rank == 0
##		comm.Recv( source = i)
##



if comm.rank == 0:
	data = [(pi(userInput) for x in range (1,size)]
	print ('scattered data before final summation: %d', %data)
	comm.scatter(data,rank=((size%4)+1))
else
	print ("I got an error at the scatter part")


if comm.rank >= 1 && rank <= size:
	print ('rank = %d recieved  this: %d', %(rank ,data))
	com.gather(data,rank=ANY)
else:
	data = None
	print ("I got an error at the recieve part")

rankUsed[size] = 0
if comm.rank == 0:
        print ("With n = %d it's accuracy, our estimates of getting closer to pi increase with a high n value." %n)



#        comm.Recv(demo, source=1)
#        print "Process", rank, "received the number", demo[0]
#
#        print "Pi is equal to %d at %d" , pi(userInput) ,userInput
        
