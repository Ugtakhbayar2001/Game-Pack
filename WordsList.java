package Java.project2.src;
import java.util.Random;

/**
 * A WordsList represents a list of words.
 * ultimately, this is a helper-class it's major purpose is to store
 * the list of words, and provide easy access to the words within.
 */
public class WordsList {
    private Random rng;

    /**
     * Construct a WordsList object
     * @param rng -- the random number generator to use. This is being passed as a constructor parameter to help with testing.
     */
    public WordsList(Random rng) {
        this.rng = rng;
    }

    /**
     *
     * @return a randomly chosen word
     */
    public String getWord() {
        return words[rng.nextInt(words.length)];
    }

    /**
     * return a randomly chosen word whose length is within the given minimum and maximum lengths (inclusive for both)
     * WARNING: This code will infinite loop if too small, or too large of a word is chosen.
     * @return a randomly chosen word within the specific size requirements
     */
    public String getWord(int minLength, int maxLength) {
        // This is not the most efficient approach, but it works well enough for a project like this.
        String word;
        do {
            word = getWord();
        } while (word.length() < minLength || word.length() > maxLength);
        return word;
    }

    // 400 general words and 200 picturable words. https://en.wiktionary.org/wiki/Appendix:Basic_English_word_list
    // A bigger/better program might want a bigger/better word list, but that's fine. This word list is good enough for us today.
    // And keeping our word list to these common words makes the games A LOT more playable.
    private static final String[] words = {
            "account",
            "act",
            "addition",
            "adjustment",
            "advertisement",
            "agreement",
            "air",
            "amount",
            "amusement",
            "animal",
            "answer",
            "apparatus",
            "approval",
            "argument",
            "art",
            "attack",
            "attempt",
            "attention",
            "attraction",
            "authority",
            "back",
            "balance",
            "base",
            "behaviour",
            "belief",
            "birth",
            "bit",
            "bite",
            "blood",
            "blow",
            "body",
            "brass",
            "bread",
            "breath",
            "brother",
            "building",
            "burn",
            "burst",
            "business",
            "butter",
            "canvas",
            "care",
            "cause",
            "chalk",
            "chance",
            "change",
            "cloth",
            "coal",
            "colour",
            "comfort",
            "committee",
            "company",
            "comparison",
            "competition",
            "condition",
            "connection",
            "control",
            "cook",
            "copper",
            "copy",
            "cork",
            "cotton",
            "cough",
            "country",
            "cover",
            "crack",
            "credit",
            "crime",
            "crush",
            "cry",
            "current",
            "curve",
            "damage",
            "danger",
            "daughter",
            "day",
            "death",
            "debt",
            "decision",
            "degree",
            "design",
            "desire",
            "destruction",
            "detail",
            "development",
            "digestion",
            "direction",
            "discovery",
            "discussion",
            "disease",
            "disgust",
            "distance",
            "distribution",
            "division",
            "doubt",
            "drink",
            "driving",
            "dust",
            "earth",
            "edge",
            "education",
            "effect",
            "end",
            "error",
            "event",
            "example",
            "exchange",
            "existence",
            "expansion",
            "experience",
            "expert",
            "fact",
            "fall",
            "family",
            "father",
            "fear",
            "feeling",
            "fiction",
            "field",
            "fight",
            "fire",
            "flame",
            "flight",
            "flower",
            "fold",
            "food",
            "force",
            "form",
            "friend",
            "front",
            "fruit",
            "glass",
            "gold",
            "government",
            "grain",
            "grass",
            "grip",
            "group",
            "growth",
            "guide",
            "harbour",
            "harmony",
            "hate",
            "hearing",
            "heat",
            "help",
            "history",
            "hole",
            "hope",
            "hour",
            "humour",
            "ice",
            "idea",
            "impulse",
            "increase",
            "industry",
            "ink",
            "insect",
            "instrument",
            "insurance",
            "interest",
            "invention",
            "iron",
            "jelly",
            "join",
            "journey",
            "judge",
            "jump",
            "kick",
            "kiss",
            "knowledge",
            "land",
            "language",
            "laugh",
            "law",
            "lead",
            "learning",
            "leather",
            "letter",
            "level",
            "lift",
            "light",
            "limit",
            "linen",
            "liquid",
            "list",
            "look",
            "loss",
            "love",
            "machine",
            "man",
            "manager",
            "mark",
            "market",
            "mass",
            "meal",
            "measure",
            "meat",
            "meeting",
            "memory",
            "metal",
            "middle",
            "milk",
            "mind",
            "mine",
            "minute",
            "mist",
            "money",
            "month",
            "morning",
            "mother",
            "motion",
            "mountain",
            "move",
            "music",
            "name",
            "nation",
            "need",
            "news",
            "night",
            "noise",
            "note",
            "number",
            "observation",
            "offer",
            "oil",
            "operation",
            "opinion",
            "order",
            "organization",
            "ornament",
            "owner",
            "page",
            "pain",
            "paint",
            "paper",
            "part",
            "paste",
            "payment",
            "peace",
            "person",
            "place",
            "plant",
            "play",
            "pleasure",
            "point",
            "poison",
            "polish",
            "porter",
            "position",
            "powder",
            "power",
            "price",
            "print",
            "process",
            "produce",
            "profit",
            "property",
            "prose",
            "protest",
            "pull",
            "punishment",
            "purpose",
            "push",
            "quality",
            "question",
            "rain",
            "range",
            "rate",
            "ray",
            "reaction",
            "reading",
            "reason",
            "record",
            "regret",
            "relation",
            "religion",
            "representative",
            "request",
            "respect",
            "rest",
            "reward",
            "rhythm",
            "rice",
            "river",
            "road",
            "roll",
            "room",
            "rub",
            "rule",
            "run",
            "salt",
            "sand",
            "scale",
            "science",
            "sea",
            "seat",
            "secretary",
            "selection",
            "self",
            "sense",
            "servant",
            "sex",
            "shade",
            "shake",
            "shame",
            "shock",
            "side",
            "sign",
            "silk",
            "silver",
            "sister",
            "size",
            "sky",
            "sleep",
            "slip",
            "slope",
            "smash",
            "smell",
            "smile",
            "smoke",
            "sneeze",
            "snow",
            "soap",
            "society",
            "son",
            "song",
            "sort",
            "sound",
            "soup",
            "space",
            "stage",
            "start",
            "statement",
            "steam",
            "steel",
            "step",
            "stitch",
            "stone",
            "stop",
            "story",
            "stretch",
            "structure",
            "substance",
            "sugar",
            "suggestion",
            "summer",
            "support",
            "surprise",
            "swim",
            "system",
            "talk",
            "taste",
            "tax",
            "teaching",
            "tendency",
            "test",
            "theory",
            "thing",
            "thought",
            "thunder",
            "time",
            "tin",
            "top",
            "touch",
            "trade",
            "transport",
            "trick",
            "trouble",
            "turn",
            "twist",
            "unit",
            "use",
            "value",
            "verse",
            "vessel",
            "view",
            "voice",
            "walk",
            "war",
            "wash",
            "waste",
            "water",
            "wave",
            "wax",
            "way",
            "weather",
            "week",
            "weight",
            "wind",
            "wine",
            "winter",
            "woman",
            "wood",
            "wool",
            "word",
            "work",
            "wound",
            "writing",
            "year",
            "angle",
            "ant",
            "apple",
            "arch",
            "arm",
            "army",
            "baby",
            "bag",
            "ball",
            "band",
            "basin",
            "basket",
            "bath",
            "bed",
            "bee",
            "bell",
            "berry",
            "bird",
            "blade",
            "board",
            "boat",
            "bone",
            "book",
            "boot",
            "bottle",
            "box",
            "boy",
            "brain",
            "brake",
            "branch",
            "brick",
            "bridge",
            "brush",
            "bucket",
            "bulb",
            "button",
            "cake",
            "camera",
            "card",
            "cart",
            "carriage",
            "cat",
            "chain",
            "cheese",
            "chest",
            "chin",
            "church",
            "circle",
            "clock",
            "cloud",
            "coat",
            "collar",
            "comb",
            "cord",
            "cow",
            "cup",
            "curtain",
            "cushion",
            "dog",
            "door",
            "drain",
            "drawer",
            "dress",
            "drop",
            "ear",
            "egg",
            "engine",
            "eye",
            "face",
            "farm",
            "feather",
            "finger",
            "fish",
            "flag",
            "floor",
            "fly",
            "foot",
            "fork",
            "fowl",
            "frame",
            "garden",
            "girl",
            "glove",
            "goat",
            "gun",
            "hair",
            "hammer",
            "hand",
            "hat",
            "head",
            "heart",
            "hook",
            "horn",
            "horse",
            "hospital",
            "house",
            "island",
            "jewel",
            "kettle",
            "key",
            "knee",
            "knife",
            "knot",
            "leaf",
            "leg",
            "library",
            "line",
            "lip",
            "lock",
            "map",
            "match",
            "monkey",
            "moon",
            "mouth",
            "muscle",
            "nail",
            "neck",
            "needle",
            "nerve",
            "net",
            "nose",
            "nut",
            "office",
            "orange",
            "oven",
            "parcel",
            "pen",
            "pencil",
            "picture",
            "pig",
            "pin",
            "pipe",
            "plane",
            "plate",
            "plough",
            "pocket",
            "pot",
            "potato",
            "prison",
            "pump",
            "rail",
            "rat",
            "receipt",
            "ring",
            "rod",
            "roof",
            "root",
            "sail",
            "school",
            "scissors",
            "screw",
            "seed",
            "sheep",
            "shelf",
            "ship",
            "shirt",
            "shoe",
            "skin",
            "skirt",
            "snake",
            "sock",
            "spade",
            "sponge",
            "spoon",
            "spring",
            "square",
            "stamp",
            "star",
            "station",
            "stem",
            "stick",
            "stocking",
            "stomach",
            "store",
            "street",
            "sun",
            "table",
            "tail",
            "thread",
            "throat",
            "thumb",
            "ticket",
            "toe",
            "tongue",
            "tooth",
            "town",
            "train",
            "tray",
            "tree",
            "trousers",
            "umbrella",
            "wall",
            "watch",
            "wheel",
            "whip",
            "whistle",
            "window",
            "wing",
            "wire",
            "worm"};

}
