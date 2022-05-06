/* Author : Ross Williams.                                                    */
/* Date   : December 1989.                                                    */
/* This header file and the C functions have been modified in order to        */
/* include them in the DouBle device driver by Jean-Marc Verbavatz, Feb 1994. */
/*                                                                            */
/* This header file defines the interface to a set of lzrw functions          */
/* each member of which implements a particular data compression              */
/* algorithm.                                                                 */
/*                                                                            */
/* Normally in C programming, for each .H file, there is a corresponding .C   */
/* file that implements the functions promised in the .H file.                */
/* Here, there are many .C files corresponding to this header file.           */
/* Each comforming implementation file contains a single function             */
/* called that implements a single data compression                           */
/* algorithm that conforms with the interface specified in this header file.  */
/*                                                                            */
/******************************************************************************/
/* See the formal C definition later for a description of the parameters.     */
/*                                                                            */
/* Although compression algorithms usually compress data, there will always   */
/* be data that a given compressor will expand (this can be proven).          */
/*                                                                            */
/* Unfortunately, in general, the only way to tell if an algorithm will       */
/* expand a particular block of data is to run the algorithm on the data.     */
/* If the algorithm does not continuously monitor how many output bytes it    */
/* has written, it might write an output block far larger than the input      */
/* block before realizing that it has done so.                                */
/* On the other hand, continuous checks on output length are inefficient.     */
/*                                                                            */
/* The problem does not arise for decompression.                              */
/*                                                                            */
/******************************************************************************/
/* Macro definitions and types that are likely to change between computers.   */
/*                                                                            */
#ifndef DONE_PORT       /* Only do this if not previously done.               */
   #ifndef TRUE
	#define TRUE 1
	#define FALSE 0
   #endif
   #ifndef UBYTE
      #define UBYTE unsigned char      /* Unsigned byte                       */
      #define UWORD unsigned short     /* Unsigned word (2 bytes)             */
      #define ULONG unsigned long      /* Unsigned word (4 bytes)             */
  #endif

   #define DONE_PORT                   /* Don't do all this again.            */
   #define LOCAL static                /* For non-exported routines.          */
   #define EXPORT                      /* Signals exported function.          */

#endif


int  rlzrw2(        /* function for decompression algorithm. */
UBYTE   *src_adr,      /* Address of input  data.            */
UBYTE   *dst_adr,      /* Address of output data.            */
int      src_len,      /* Length  of input  data.            */
int     *dst_len       /* Length  of output data.            */
);

int  wlzrw2(        /* function for compression algorithm. */
UBYTE   *src_adr,      /* Address of input  data.           */
int      src_len,      /* Length  of input  data.           */
UBYTE   *dst_adr,      /* Address of output data.           */
int   *p_dst_len       /* Pointer to a longword for         */
                       /*    Length of output data. */
);

void *lzrw2_initialize(int *bytes);

/******************************************************************************/
/*                             End of LZRW.H                                  */
/******************************************************************************/

