package jevm.core;

import static jevm.util.Word.*;

public class Account {
	/**
	 * A scalar value equal to the number of transactions sent from this address
	 * or, in the case of accounts with associated code, the number of
	 * contract-creations made by this account.
	 */
	private w256 nonce;

	/**
	 * A scalar value equal to the number of Wei owned by this address
	 */
	private w256 balance;

	/**
	 * A 256-bit hash of the root node of a Merkle Patricia tree that encodes the
	 * storage contents of the account (a mapping between 256-bit integer values),
	 * encoded into the trie as a mapping from the Keccak 256-bit hash of the
	 * 256-bit integer keys to the RLP-encoded 256-bit integer values
	 */
	private w256 storage;

	/**
	 * The hash of the EVM code of this account—this is the code that gets executed
	 * should this address receive a message call; it is immutable and thus, unlike
	 * all other fields, cannot be changed after construction. All such code
	 * fragments are contained in the state database un- der their corresponding
	 * hashes for later retrieval
	 */
	private final w256 codeHash;

	/**
	 * Construct a new account, with a corresponding code hash.
	 *
	 * @param codeHash
	 */
	public Account(w256 codeHash) {
		this.nonce = new w256(0);
		this.balance = new w256(0);
		this.codeHash = codeHash;
	}
}
