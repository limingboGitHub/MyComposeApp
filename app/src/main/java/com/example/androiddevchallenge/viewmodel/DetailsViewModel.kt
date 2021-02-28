/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.PuppyDetails

class DetailsViewModel : ViewModel() {

    val puppyDetails = MutableLiveData<PuppyDetails>()

    fun getDetails(id: Int) {
        val detailsList = listOf(
            PuppyDetails(0, "Golden retriever", 10, "M", "The Golden Retriever is a medium-large gun dog that was bred to retrieve shot waterfowl, such as ducks and upland game birds, during hunting and shooting parties. The name \"retriever\" refers to the breed's ability to retrieve shot game undamaged due to their soft mouth. Golden retrievers have an instinctive love of water, and are easy to train to basic or advanced obedience standards. They are a long-coated breed, with a dense inner coat that provides them with adequate warmth in the outdoors, and an outer coat that lies flat against their bodies and repels water. Golden retrievers are well suited to residency in suburban or country environments. They shed copiously, particularly at the change of seasons, and require fairly regular grooming. The Golden Retriever was originally bred in Scotland in the mid-19th century"),
            PuppyDetails(1, "Pug", 16, "F", "The pug is a breed of dog with physically distinctive features of a wrinkly, short-muzzled face, and curled tail. The breed has a fine, glossy coat that comes in a variety of colours, most often light brown (fawn) or black, and a compact, square body with well-developed muscles.\n Pugs were brought from China to Europe in the sixteenth century and were popularized in Western Europe by the House of Orange of the Netherlands, and the House of Stuart. In the United Kingdom, in the nineteenth century, Queen Victoria developed a passion for pugs which she passed on to other members of the Royal family"),
            PuppyDetails(2, "Teddy", 30, "M", "The Teddy dog is actually a beauty model for poodles. The VIP is a French variety, and it looks very lovely. Once used as a waterbird. In 19th Century and 20th Century, the species reached its peak for hunting, performance and companionship. They are divided into four groups according to their size: the most popular ones are smaller ones: Mini poodles and Toy Poodles. Among them, the toy poodle is the smallest body shape. It is active, active, alert, intelligent, likes to go out and adaptable."),
            PuppyDetails(3, "Shepherd", 8, "M", "\"Shepherd\" is given a full-time herding dogs, not a single species, \"family\", DingXingWang dogs, including \"the Scottish collie\", \"the shetland sheepdog\", \"the border collie\", etc. Millions of years in the past, shepherd is responsible for shepherds and animal husbandry and breed. Is responsible for security, avoid in farm cattle, sheep, horses etc escape or lost, also protect livestock from bear or Wolf, but also greatly to eliminate the theft behavior. It is only as the watchers, and also to cattle sheep and oxen will be responsible to market transactions, is rare, farmers are also necessary good assistant. With the development of history, shepherd gradually by all the royal that the upper-class and ordinary citizens are gradually put it as to enjoy the dog keepers."),
            PuppyDetails(4, "Shiba inu", 12, "F", "The Shiba Inu (柴犬, Japanese: [ɕiba inɯ]) is a breed of hunting dog from Japan. A small-to-medium breed, it is the smallest of the six original and distinct spitz breeds of dog native to Japan.\n" + "A small, alert and agile dog that copes very well with mountainous terrain and hiking trails, the Shiba Inu was originally bred for hunting. It looks similar to and is often mistaken for other Japanese dog breeds such as the Akita Inu or Hokkaido, but the Shiba Inu is a different breed with a distinct blood line, temperament, and smaller size than other Japanese dog breeds."),
            PuppyDetails(5, "Corgi", 22, "F", "The Welsh Corgi (/ˈkɔːrɡi/ sometimes known as Corgi, plural Corgis, or occasionally the etymologically consistent \"Corgwn\"; /ˈkɔːrɡuːn/) is a small type of herding dog that originated in Wales. Two separate breeds are recognised: the Pembroke Welsh Corgi and the Cardigan Welsh Corgi. There are physical differences between the two. According to the breed standards, overall the Cardigan is larger, both in weight and in height. Their tails are of different shapes; docking had previously been used"),
        )

        detailsList.forEach {
            if (it.id == id) {
                puppyDetails.value = it
            }
        }
    }
}
