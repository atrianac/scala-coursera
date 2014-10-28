package patmat

import patmat.Huffman.Leaf
import patmat.Huffman.Fork
import patmat.Huffman.CodeTree


object HuffmanWorksheet {
  
  var chars = List('h','e','l','l','o','c','r','u','e','l')
                                                  //> chars  : List[Char] = List(h, e, l, l, o, c, r, u, e, l)
  
  val tree = Huffman.makeCodeTree(Huffman.makeCodeTree(Leaf('h', 1), Leaf('e', 1)), Leaf('l', 2))
                                                  //> tree  : patmat.Huffman.Fork = Fork(Fork(Leaf(h,1),Leaf(e,1),List(h, e),2),Le
                                                  //| af(l,2),List(h, e, l),4)
  
  val freqs = Huffman.times(chars)                //> freqs  : List[(Char, Int)] = List((h,1), (e,2), (l,3), (o,1), (c,1), (r,1), 
                                                  //| (u,1))
                                                  
  val ordered = Huffman.makeOrderedLeafList(freqs)//> ordered  : List[patmat.Huffman.Leaf] = List(Leaf(h,1), Leaf(o,1), Leaf(c,1),
                                                  //|  Leaf(r,1), Leaf(u,1), Leaf(e,2), Leaf(l,3))
                                                  
  val combine1 = Huffman.combine(ordered)         //> combine1  : List[patmat.Huffman.CodeTree] = List(Leaf(c,1), Leaf(r,1), Leaf(
                                                  //| u,1), Leaf(e,2), Fork(Leaf(h,1),Leaf(o,1),List(h, o),2), Leaf(l,3))
                                                  
  Huffman.until(false, combine1)(combine1)        //> res0: patmat.Huffman.CodeTree = Fork(Fork(Fork(Leaf(h,1),Leaf(o,1),List(h, o
                                                  //| ),2),Fork(Leaf(c,1),Leaf(r,1),List(c, r),2),List(h, o, c, r),4),Fork(Leaf(l,
                                                  //| 3),Fork(Leaf(u,1),Leaf(e,2),List(u, e),3),List(l, u, e),6),List(h, o, c, r, 
                                                  //| l, u, e),10)
                                                  
  def codeTree = Huffman.createCodeTree(chars)    //> codeTree: => patmat.Huffman.CodeTree
                                                  
  def bits = Huffman.encode(codeTree)(chars)      //> bits: => List[patmat.Huffman.Bit]
  
  println(bits)                                   //> List(0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1,
                                                  //|  1, 1, 0)
  
  Huffman.decode(codeTree, bits)                  //> res1: List[Char] = List(h, e, l, l, o, c, r, u, e, l)
                                                  
  Huffman.decodedSecret                           //> res2: List[Char] = List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)
  
}