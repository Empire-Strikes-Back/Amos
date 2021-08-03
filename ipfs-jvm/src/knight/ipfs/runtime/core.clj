(ns knight.ipfs.runtime.core
  (:require
   [clojure.core.async :as a :refer [chan go go-loop <! >! take! put! offer! poll! do-alts alt! alts! close!
                                     pub sub unsub mult tap untap mix admix unmix pipe
                                     timeout to-chan  sliding-buffer dropping-buffer
                                     pipeline pipeline-async]]

   [knight.bytes.protocols :as bytes.protocols]
   [knight.bytes.runtime.core :as bytes.runtime.core]
   [knight.varint.core :as varint.core]

   [knight.ipfs.runtime.crypto :as ipfs.runtime.crypto]
   [knight.ipfs.protocols :as ipfs.protocols]
   [knight.ipfs.spec :as ipfs.spec])
  (:import
   (io.ipfs.multiaddr MultiAddress)
   (io.ipfs.multibase Multibase Base58)
   (io.ipfs.multihash Multihash Multihash$Type)
   (io.ipfs.cid Cid Cid$Codec)
   (io.libp2p.core Connection Host PeerId)
   (knight.ipfs.runtime NodeProto$DhtMessage NodeProto$DhtMessage$Type)))

(do (set! *warn-on-reflection* true) (set! *unchecked-math* true))